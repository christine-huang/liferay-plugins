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

package com.liferay.saml.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SamlIdpSsoSession service. Represents a row in the &quot;SamlIdpSsoSession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.saml.model.impl.SamlIdpSsoSessionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.saml.model.impl.SamlIdpSsoSessionImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlIdpSsoSession
 * @see com.liferay.saml.model.impl.SamlIdpSsoSessionImpl
 * @see com.liferay.saml.model.impl.SamlIdpSsoSessionModelImpl
 * @generated
 */
public interface SamlIdpSsoSessionModel extends AuditedModel,
	BaseModel<SamlIdpSsoSession> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a saml idp sso session model instance should use the {@link SamlIdpSsoSession} interface instead.
	 */

	/**
	 * Returns the primary key of this saml idp sso session.
	 *
	 * @return the primary key of this saml idp sso session
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this saml idp sso session.
	 *
	 * @param primaryKey the primary key of this saml idp sso session
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the saml idp sso session ID of this saml idp sso session.
	 *
	 * @return the saml idp sso session ID of this saml idp sso session
	 */
	public long getSamlIdpSsoSessionId();

	/**
	 * Sets the saml idp sso session ID of this saml idp sso session.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID of this saml idp sso session
	 */
	public void setSamlIdpSsoSessionId(long samlIdpSsoSessionId);

	/**
	 * Returns the company ID of this saml idp sso session.
	 *
	 * @return the company ID of this saml idp sso session
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this saml idp sso session.
	 *
	 * @param companyId the company ID of this saml idp sso session
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this saml idp sso session.
	 *
	 * @return the user ID of this saml idp sso session
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this saml idp sso session.
	 *
	 * @param userId the user ID of this saml idp sso session
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this saml idp sso session.
	 *
	 * @return the user uuid of this saml idp sso session
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this saml idp sso session.
	 *
	 * @param userUuid the user uuid of this saml idp sso session
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this saml idp sso session.
	 *
	 * @return the user name of this saml idp sso session
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this saml idp sso session.
	 *
	 * @param userName the user name of this saml idp sso session
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this saml idp sso session.
	 *
	 * @return the create date of this saml idp sso session
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this saml idp sso session.
	 *
	 * @param createDate the create date of this saml idp sso session
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this saml idp sso session.
	 *
	 * @return the modified date of this saml idp sso session
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this saml idp sso session.
	 *
	 * @param modifiedDate the modified date of this saml idp sso session
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the saml idp sso session key of this saml idp sso session.
	 *
	 * @return the saml idp sso session key of this saml idp sso session
	 */
	@AutoEscape
	public String getSamlIdpSsoSessionKey();

	/**
	 * Sets the saml idp sso session key of this saml idp sso session.
	 *
	 * @param samlIdpSsoSessionKey the saml idp sso session key of this saml idp sso session
	 */
	public void setSamlIdpSsoSessionKey(String samlIdpSsoSessionKey);

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

	public int compareTo(SamlIdpSsoSession samlIdpSsoSession);

	public int hashCode();

	public CacheModel<SamlIdpSsoSession> toCacheModel();

	public SamlIdpSsoSession toEscapedModel();

	public String toString();

	public String toXmlString();
}