<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

FileEntry fileEntry = null;
DLFileShortcut fileShortcut = null;

boolean showWhenSingleIcon = false;

if (portletId.equals(PortletKeys.DOCUMENT_LIBRARY)) {
	showWhenSingleIcon = true;
}

if (row != null) {
	Object result = row.getObject();

	if (result instanceof AssetEntry) {
		AssetEntry assetEntry = (AssetEntry)result;

		if (assetEntry.getClassName().equals(DLFileEntryConstants.getClassName())) {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(assetEntry.getClassPK());
		}
		else {
			fileShortcut = DLAppLocalServiceUtil.getFileShortcut(assetEntry.getClassPK());
		}
	}
	else if (result instanceof FileEntry) {
		fileEntry = (FileEntry)result;
	}
	else {
		fileShortcut = (DLFileShortcut)result;
	}
}
else {
	if (portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY)) {
		if (request.getAttribute("view_file_entry.jsp-fileEntry") != null) {
			fileEntry = (FileEntry)request.getAttribute("view_file_entry.jsp-fileEntry");

			if (request.getAttribute("view_file_entry.jsp-fileShortcut") != null) {
				fileShortcut = (DLFileShortcut)request.getAttribute("view_file_entry.jsp-fileShortcut");
			}
		}
		else {
			fileShortcut = (DLFileShortcut)request.getAttribute("view_file_shortcut.jsp-fileShortcut");
		}
	}
	else {
		if (request.getAttribute("view_entries.jsp-fileEntry") != null) {
			fileEntry = (FileEntry)request.getAttribute("view_entries.jsp-fileEntry");

			if (request.getAttribute("view_entries.jsp-fileShortcut") != null) {
				fileShortcut = (DLFileShortcut)request.getAttribute("view_entries.jsp-fileShortcut");
			}

		}
		else {
			fileShortcut = (DLFileShortcut)request.getAttribute("view_file_shortcut.jsp-fileShortcut");
		}
	}
}

long folderId = 0;

if (fileEntry != null) {
	folderId = fileEntry.getFolderId();
}
else if (fileShortcut != null) {
	folderId = fileShortcut.getFolderId();
}

PortletURL viewFolderURL = liferayPortletResponse.createRenderURL();

viewFolderURL.setParameter("struts_action", "/document_library/view");
viewFolderURL.setParameter("folderId", String.valueOf(folderId));
%>

<liferay-util:buffer var="iconMenu">
	<liferay-ui:icon-menu align='<%= portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) ? "right" : "auto" %>' direction='<%= portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) ? null : "down" %>' extended="<%= portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) ? true : false %>" icon="<%= portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) ? null : StringPool.BLANK %>" message='<%= portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) ? "actions" : StringPool.BLANK %>' showExpanded="<%= false %>" showWhenSingleIcon="<%= showWhenSingleIcon %>">
		<c:choose>
			<c:when test="<%= (fileEntry != null) && (fileShortcut == null) %>">
				<c:if test="<%= DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.VIEW) %>">
					<liferay-ui:icon
						image="download"
						message='<%= LanguageUtil.get(pageContext, "download") + " (" + TextFormatter.formatKB(fileEntry.getSize(), locale) + "k)" %>'
						url="<%= DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, true) %>"
					/>
				</c:if>

				<portlet:actionURL var="checkOutURL">
					<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.CHECKOUT %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntry.getFileEntryId()) %>" />
				</portlet:actionURL>

				<c:if test="<%= showActions && DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.UPDATE) %>">

					<%
					if (portletDisplay.isWebDAVEnabled() && BrowserSnifferUtil.isIe(request)) {
						String webDavUrl = DLUtil.getWebDavURL(themeDisplay, fileEntry.getFolder(), fileEntry);

						String curExtension = fileEntry.getExtension();

						if (curExtension.equalsIgnoreCase("doc") ||
							curExtension.equalsIgnoreCase("docx") ||
							curExtension.equalsIgnoreCase("dot") ||
							curExtension.equalsIgnoreCase("ppt") ||
							curExtension.equalsIgnoreCase("pptx") ||
							curExtension.equalsIgnoreCase("xls") ||
							curExtension.equalsIgnoreCase("xlsx")) {

							String taglibOnClick = liferayPortletResponse.getNamespace() + "editAndCheckout('" + checkOutURL.toString() + "'); Liferay.fire('" + liferayPortletResponse.getNamespace() + "openDocument', {webDavUrl: '" + webDavUrl + "'});";
					%>

							<liferay-ui:icon
								image="../document_library/msoffice"
								message="open-in-ms-office"
								onClick="<%= taglibOnClick %>"
								url="javascript:;"
							/>

					<%
						}
					}
					%>

					<portlet:renderURL var="editURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						<portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntry.getFileEntryId()) %>" />
					</portlet:renderURL>

					<%
					String taglibOnClickEdit = liferayPortletResponse.getNamespace() + "editAndCheckout('" + checkOutURL.toString() + "');" + liferayPortletResponse.getNamespace() + "openDialog('" + editURL.toString() + "', '" + UnicodeLanguageUtil.get(pageContext, "edit") +"');";
					%>

					<liferay-ui:icon
						image="edit"
						onClick="<%= taglibOnClickEdit %>"
						url="javascript:;"
					/>
				</c:if>

				<c:if test="<%= showActions && DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.UPDATE) %>">
					<portlet:renderURL var="moveURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="struts_action" value="/document_library/move_file_entry" />
						<portlet:param name="redirect" value="<%= viewFolderURL.toString() %>" />
						<portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntry.getFileEntryId()) %>" />
					</portlet:renderURL>

					<%
					String taglibOnClickMove = liferayPortletResponse.getNamespace() + "openDialog('" + moveURL.toString() + "', '" + UnicodeLanguageUtil.get(pageContext, "move") +"');";
					%>

					<liferay-ui:icon
						image="submit"
						message="move"
						onClick="<%= taglibOnClickMove %>"
						url="javascript:;"
					/>
				</c:if>

				<c:if test="<%= showActions %>">
					<c:if test="<%= DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.UPDATE) && fileEntry.isSupportsLocking() %>">
						<c:choose>
							<c:when test="<%= !fileEntry.isCheckedOut() %>">
								<liferay-ui:icon
									image="lock"
									message="checkout[document]"
									url="<%= checkOutURL %>"
								/>
							</c:when>
							<c:otherwise>
								<c:if test="<%= fileEntry.hasLock() || (permissionChecker.isGroupAdmin(fileEntry.getRepositoryId()) && fileEntry.isCheckedOut()) %>">
									<portlet:renderURL var="checkInURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
										<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
										<portlet:param name="redirect" value="<%= currentURL %>" />
										<portlet:param name="backURL" value="<%= currentURL %>" />
										<portlet:param name="displaySection" value="checkin" />
										<portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntry.getFileEntryId()) %>" />
									</portlet:renderURL>

									<%
									String taglibOnClickCheckin = liferayPortletResponse.getNamespace() + "openDialog('" + checkInURL.toString() + "', '" + UnicodeLanguageUtil.get(pageContext, "move") +"');";
									%>

									<liferay-ui:icon
										image="unlock"
										message="checkin"
										onClick="<%= taglibOnClickCheckin %>"
										url="javascript:;"
									/>

									<portlet:actionURL var="cancelCheckOutURL">
										<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
										<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.CANCEL_CHECKOUT %>" />
										<portlet:param name="redirect" value="<%= currentURL %>" />
										<portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntry.getFileEntryId()) %>" />
									</portlet:actionURL>

									<liferay-ui:icon
										image="undo"
										message="cancel-checkout[document]"
										url="<%= cancelCheckOutURL %>"
									/>
								</c:if>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:if>

				<c:if test="<%= showActions && DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%= DLFileEntryConstants.getClassName() %>"
						modelResourceDescription="<%= HtmlUtil.unescape(fileEntry.getTitle()) %>"
						resourcePrimKey="<%= String.valueOf(fileEntry.getFileEntryId()) %>"
						var="permissionsURL"
					/>

					<liferay-ui:icon
						image="permissions"
						url="<%= permissionsURL %>"
					/>
				</c:if>

				<c:if test="<%= showActions && DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.DELETE) %>">
					<portlet:actionURL var="deleteURL">
						<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
						<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
						<portlet:param name="redirect" value="<%= viewFolderURL.toString() %>" />
						<portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntry.getFileEntryId()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon-delete
						url="<%= deleteURL %>"
					/>
				</c:if>
			</c:when>
			<c:otherwise>

				<%
				fileEntry = DLAppLocalServiceUtil.getFileEntry(fileShortcut.getToFileEntryId());
				%>

				<c:if test="<%= DLFileShortcutPermission.contains(permissionChecker, fileShortcut, ActionKeys.VIEW) %>">
					<liferay-ui:icon
						image="download"
						message='<%= LanguageUtil.get(pageContext, "download") + " (" + TextFormatter.formatKB(fileEntry.getSize(), locale) + "k)" %>'
						url='<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + fileShortcut.getFileShortcutId() %>'
					/>
				</c:if>

				<c:if test="<%= DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.UPDATE) %>">
					<portlet:renderURL var="viewOriginalFileURL">
						<portlet:param name="struts_action" value="/document_library/view_file_entry" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="fileEntryId" value="<%= String.valueOf(fileShortcut.getToFileEntryId()) %>" />
					</portlet:renderURL>

					<liferay-ui:icon
						image="view"
						message="view-original-file"
						url="<%= viewOriginalFileURL %>"
					/>
				</c:if>

				<c:if test="<%= showActions && DLFileShortcutPermission.contains(permissionChecker, fileShortcut, ActionKeys.UPDATE) %>">
					<portlet:renderURL var="editShortcutURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="struts_action" value="/document_library/edit_file_shortcut" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="fileShortcutId" value="<%= String.valueOf(fileShortcut.getFileShortcutId()) %>" />
					</portlet:renderURL>

					<%
					String taglibOnClickEdit = liferayPortletResponse.getNamespace() + "openDialog('" + editShortcutURL.toString() + "', '" + UnicodeLanguageUtil.get(pageContext, "permissions") +"');";
					%>

					<liferay-ui:icon
						image="edit"
						onClick="<%= taglibOnClickEdit %>"
						url="javascript:;"
					/>
				</c:if>

				<c:if test="<%= showActions && DLFileShortcutPermission.contains(permissionChecker, fileShortcut, ActionKeys.PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%= DLFileShortcut.class.getName() %>"
						modelResourceDescription="<%= fileEntry.getTitle() %>"
						resourcePrimKey="<%= String.valueOf(fileShortcut.getFileShortcutId()) %>"
						var="shortcutPermissionsURL"
					/>

					<liferay-ui:icon
						image="permissions"
						url="<%= shortcutPermissionsURL %>"
					/>
				</c:if>

				<c:if test="<%= showActions && DLFileShortcutPermission.contains(permissionChecker, fileShortcut, ActionKeys.DELETE) %>">
					<portlet:actionURL var="deleteShortcutURL">
						<portlet:param name="struts_action" value="/document_library/edit_file_shortcut" />
						<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
						<portlet:param name="redirect" value="<%= viewFolderURL.toString() %>" />
						<portlet:param name="fileShortcutId" value="<%= String.valueOf(fileShortcut.getFileShortcutId()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon-delete
						url="<%= deleteShortcutURL %>"
					/>
				</c:if>
			</c:otherwise>
		</c:choose>
	</liferay-ui:icon-menu>
</liferay-util:buffer>

<c:choose>
	<c:when test="<%= portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) %>">

		<%= iconMenu %>

	</c:when>
	<c:otherwise>
		<span class="overlay document-action">

			<%= iconMenu %>

		</span>
	</c:otherwise>
</c:choose>