/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.saml.resolver;

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.util.OpenSamlUtil;

import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDPolicy;

/**
 * @author Mika Koivisto
 */
public class DefaultNameIdResolver implements NameIdResolver {

	public NameID resolve(
		User user, String entityId, NameIDPolicy nameIdPolicy) {

		String nameIdFormat = getNameIdFormat(entityId, nameIdPolicy);
		String nameIdValue = getNameIdValue(user, entityId);

		return OpenSamlUtil.buildNameId(nameIdFormat, nameIdValue);
	}

	protected String getNameIdAttributeName(String entityId) {
		return MetadataManagerUtil.getNameIdAttribute(entityId);
	}

	protected String getNameIdFormat(
		String entityId, NameIDPolicy nameIdPolicy) {

		if ((nameIdPolicy != null) &&
			Validator.isNotNull(nameIdPolicy.getFormat())) {

			return nameIdPolicy.getFormat();
		}

		return MetadataManagerUtil.getNameIdFormat(entityId);
	}

	protected String getNameIdValue(User user, String entityId) {
		String nameIdAttributeName = getNameIdAttributeName(entityId);

		String nameIdValue = user.getEmailAddress();

		if (Validator.isNull(nameIdAttributeName)) {
			return nameIdValue;
		}

		if (nameIdAttributeName.startsWith("expando:")) {
			String attributeName = nameIdAttributeName.substring(8);

			ExpandoBridge expandoBridge = user.getExpandoBridge();

			nameIdValue = String.valueOf(
				expandoBridge.getAttribute(attributeName));
		}
		else {
			nameIdValue = String.valueOf(
				BeanPropertiesUtil.getObject(user, nameIdAttributeName));
		}

		return nameIdValue;
	}

}