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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mika Koivisto
 */
public class SamlIdpSsoSessionClp extends BaseModelImpl<SamlIdpSsoSession>
	implements SamlIdpSsoSession {
	public SamlIdpSsoSessionClp() {
	}

	public Class<?> getModelClass() {
		return SamlIdpSsoSession.class;
	}

	public String getModelClassName() {
		return SamlIdpSsoSession.class.getName();
	}

	public long getPrimaryKey() {
		return _samlIdpSsoSessionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSamlIdpSsoSessionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_samlIdpSsoSessionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("samlIdpSsoSessionId", getSamlIdpSsoSessionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("samlIdpSsoSessionKey", getSamlIdpSsoSessionKey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long samlIdpSsoSessionId = (Long)attributes.get("samlIdpSsoSessionId");

		if (samlIdpSsoSessionId != null) {
			setSamlIdpSsoSessionId(samlIdpSsoSessionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String samlIdpSsoSessionKey = (String)attributes.get(
				"samlIdpSsoSessionKey");

		if (samlIdpSsoSessionKey != null) {
			setSamlIdpSsoSessionKey(samlIdpSsoSessionKey);
		}
	}

	public long getSamlIdpSsoSessionId() {
		return _samlIdpSsoSessionId;
	}

	public void setSamlIdpSsoSessionId(long samlIdpSsoSessionId) {
		_samlIdpSsoSessionId = samlIdpSsoSessionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getSamlIdpSsoSessionKey() {
		return _samlIdpSsoSessionKey;
	}

	public void setSamlIdpSsoSessionKey(String samlIdpSsoSessionKey) {
		_samlIdpSsoSessionKey = samlIdpSsoSessionKey;
	}

	public boolean isExpired() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getSamlIdpSsoSessionRemoteModel() {
		return _samlIdpSsoSessionRemoteModel;
	}

	public void setSamlIdpSsoSessionRemoteModel(
		BaseModel<?> samlIdpSsoSessionRemoteModel) {
		_samlIdpSsoSessionRemoteModel = samlIdpSsoSessionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SamlIdpSsoSessionLocalServiceUtil.addSamlIdpSsoSession(this);
		}
		else {
			SamlIdpSsoSessionLocalServiceUtil.updateSamlIdpSsoSession(this);
		}
	}

	@Override
	public SamlIdpSsoSession toEscapedModel() {
		return (SamlIdpSsoSession)ProxyUtil.newProxyInstance(SamlIdpSsoSession.class.getClassLoader(),
			new Class[] { SamlIdpSsoSession.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public SamlIdpSsoSession toUnescapedModel() {
		if (ProxyUtil.isProxyClass(getClass())) {
			InvocationHandler invocationHandler = ProxyUtil.getInvocationHandler(this);

			AutoEscapeBeanHandler autoEscapeBeanHandler = (AutoEscapeBeanHandler)invocationHandler;

			return (SamlIdpSsoSession)autoEscapeBeanHandler.getBean();
		}
		else {
			return (SamlIdpSsoSession)this;
		}
	}

	@Override
	public Object clone() {
		SamlIdpSsoSessionClp clone = new SamlIdpSsoSessionClp();

		clone.setSamlIdpSsoSessionId(getSamlIdpSsoSessionId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSamlIdpSsoSessionKey(getSamlIdpSsoSessionKey());

		return clone;
	}

	public int compareTo(SamlIdpSsoSession samlIdpSsoSession) {
		long primaryKey = samlIdpSsoSession.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SamlIdpSsoSessionClp samlIdpSsoSession = null;

		try {
			samlIdpSsoSession = (SamlIdpSsoSessionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = samlIdpSsoSession.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{samlIdpSsoSessionId=");
		sb.append(getSamlIdpSsoSessionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", samlIdpSsoSessionKey=");
		sb.append(getSamlIdpSsoSessionKey());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.saml.model.SamlIdpSsoSession");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>samlIdpSsoSessionId</column-name><column-value><![CDATA[");
		sb.append(getSamlIdpSsoSessionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>samlIdpSsoSessionKey</column-name><column-value><![CDATA[");
		sb.append(getSamlIdpSsoSessionKey());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _samlIdpSsoSessionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _samlIdpSsoSessionKey;
	private BaseModel<?> _samlIdpSsoSessionRemoteModel;
}