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

package com.liferay.portal.workflow.kaleo.forms.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KaleoProcess service. Represents a row in the &quot;KaleoProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessImpl}.
 * </p>
 *
 * @author Marcellus Tavares
 * @see KaleoProcess
 * @see com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessImpl
 * @see com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessModelImpl
 * @generated
 */
public interface KaleoProcessModel extends BaseModel<KaleoProcess>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo process model instance should use the {@link KaleoProcess} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo process.
	 *
	 * @return the primary key of this kaleo process
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo process.
	 *
	 * @param primaryKey the primary key of this kaleo process
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the kaleo process ID of this kaleo process.
	 *
	 * @return the kaleo process ID of this kaleo process
	 */
	public long getKaleoProcessId();

	/**
	 * Sets the kaleo process ID of this kaleo process.
	 *
	 * @param kaleoProcessId the kaleo process ID of this kaleo process
	 */
	public void setKaleoProcessId(long kaleoProcessId);

	/**
	 * Returns the group ID of this kaleo process.
	 *
	 * @return the group ID of this kaleo process
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo process.
	 *
	 * @param groupId the group ID of this kaleo process
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo process.
	 *
	 * @return the company ID of this kaleo process
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo process.
	 *
	 * @param companyId the company ID of this kaleo process
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo process.
	 *
	 * @return the user ID of this kaleo process
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this kaleo process.
	 *
	 * @param userId the user ID of this kaleo process
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo process.
	 *
	 * @return the user uuid of this kaleo process
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this kaleo process.
	 *
	 * @param userUuid the user uuid of this kaleo process
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo process.
	 *
	 * @return the user name of this kaleo process
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this kaleo process.
	 *
	 * @param userName the user name of this kaleo process
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo process.
	 *
	 * @return the create date of this kaleo process
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo process.
	 *
	 * @param createDate the create date of this kaleo process
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo process.
	 *
	 * @return the modified date of this kaleo process
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo process.
	 *
	 * @param modifiedDate the modified date of this kaleo process
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the d d l record set ID of this kaleo process.
	 *
	 * @return the d d l record set ID of this kaleo process
	 */
	public long getDDLRecordSetId();

	/**
	 * Sets the d d l record set ID of this kaleo process.
	 *
	 * @param DDLRecordSetId the d d l record set ID of this kaleo process
	 */
	public void setDDLRecordSetId(long DDLRecordSetId);

	/**
	 * Returns the d d m template ID of this kaleo process.
	 *
	 * @return the d d m template ID of this kaleo process
	 */
	public long getDDMTemplateId();

	/**
	 * Sets the d d m template ID of this kaleo process.
	 *
	 * @param DDMTemplateId the d d m template ID of this kaleo process
	 */
	public void setDDMTemplateId(long DDMTemplateId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(KaleoProcess kaleoProcess);

	public int hashCode();

	public CacheModel<KaleoProcess> toCacheModel();

	public KaleoProcess toEscapedModel();

	public KaleoProcess toUnescapedModel();

	public String toString();

	public String toXmlString();
}