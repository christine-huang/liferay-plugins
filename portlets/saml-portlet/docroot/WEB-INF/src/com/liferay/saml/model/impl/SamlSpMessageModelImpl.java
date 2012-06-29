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

package com.liferay.saml.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.saml.model.SamlSpMessage;
import com.liferay.saml.model.SamlSpMessageModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SamlSpMessage service. Represents a row in the &quot;SamlSpMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.saml.model.SamlSpMessageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SamlSpMessageImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlSpMessageImpl
 * @see com.liferay.saml.model.SamlSpMessage
 * @see com.liferay.saml.model.SamlSpMessageModel
 * @generated
 */
public class SamlSpMessageModelImpl extends BaseModelImpl<SamlSpMessage>
	implements SamlSpMessageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a saml sp message model instance should use the {@link com.liferay.saml.model.SamlSpMessage} interface instead.
	 */
	public static final String TABLE_NAME = "SamlSpMessage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "samlSpMessageId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "samlIdpEntityId", Types.VARCHAR },
			{ "samlIdpResponseKey", Types.VARCHAR },
			{ "expirationDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SamlSpMessage (samlSpMessageId LONG not null primary key,companyId LONG,createDate DATE null,samlIdpEntityId VARCHAR(1024) null,samlIdpResponseKey VARCHAR(75) null,expirationDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table SamlSpMessage";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.saml.model.SamlSpMessage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.saml.model.SamlSpMessage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.saml.model.SamlSpMessage"),
			true);
	public static long SAMLIDPENTITYID_COLUMN_BITMASK = 1L;
	public static long SAMLIDPRESPONSEKEY_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.saml.model.SamlSpMessage"));

	public SamlSpMessageModelImpl() {
	}

	public long getPrimaryKey() {
		return _samlSpMessageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSamlSpMessageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_samlSpMessageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return SamlSpMessage.class;
	}

	public String getModelClassName() {
		return SamlSpMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("samlSpMessageId", getSamlSpMessageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("samlIdpEntityId", getSamlIdpEntityId());
		attributes.put("samlIdpResponseKey", getSamlIdpResponseKey());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long samlSpMessageId = (Long)attributes.get("samlSpMessageId");

		if (samlSpMessageId != null) {
			setSamlSpMessageId(samlSpMessageId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String samlIdpEntityId = (String)attributes.get("samlIdpEntityId");

		if (samlIdpEntityId != null) {
			setSamlIdpEntityId(samlIdpEntityId);
		}

		String samlIdpResponseKey = (String)attributes.get("samlIdpResponseKey");

		if (samlIdpResponseKey != null) {
			setSamlIdpResponseKey(samlIdpResponseKey);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	public long getSamlSpMessageId() {
		return _samlSpMessageId;
	}

	public void setSamlSpMessageId(long samlSpMessageId) {
		_samlSpMessageId = samlSpMessageId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getSamlIdpEntityId() {
		if (_samlIdpEntityId == null) {
			return StringPool.BLANK;
		}
		else {
			return _samlIdpEntityId;
		}
	}

	public void setSamlIdpEntityId(String samlIdpEntityId) {
		_columnBitmask |= SAMLIDPENTITYID_COLUMN_BITMASK;

		if (_originalSamlIdpEntityId == null) {
			_originalSamlIdpEntityId = _samlIdpEntityId;
		}

		_samlIdpEntityId = samlIdpEntityId;
	}

	public String getOriginalSamlIdpEntityId() {
		return GetterUtil.getString(_originalSamlIdpEntityId);
	}

	public String getSamlIdpResponseKey() {
		if (_samlIdpResponseKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _samlIdpResponseKey;
		}
	}

	public void setSamlIdpResponseKey(String samlIdpResponseKey) {
		_columnBitmask |= SAMLIDPRESPONSEKEY_COLUMN_BITMASK;

		if (_originalSamlIdpResponseKey == null) {
			_originalSamlIdpResponseKey = _samlIdpResponseKey;
		}

		_samlIdpResponseKey = samlIdpResponseKey;
	}

	public String getOriginalSamlIdpResponseKey() {
		return GetterUtil.getString(_originalSamlIdpResponseKey);
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public SamlSpMessage toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (SamlSpMessage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SamlSpMessage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		SamlSpMessageImpl samlSpMessageImpl = new SamlSpMessageImpl();

		samlSpMessageImpl.setSamlSpMessageId(getSamlSpMessageId());
		samlSpMessageImpl.setCompanyId(getCompanyId());
		samlSpMessageImpl.setCreateDate(getCreateDate());
		samlSpMessageImpl.setSamlIdpEntityId(getSamlIdpEntityId());
		samlSpMessageImpl.setSamlIdpResponseKey(getSamlIdpResponseKey());
		samlSpMessageImpl.setExpirationDate(getExpirationDate());

		samlSpMessageImpl.resetOriginalValues();

		return samlSpMessageImpl;
	}

	public int compareTo(SamlSpMessage samlSpMessage) {
		long primaryKey = samlSpMessage.getPrimaryKey();

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

		SamlSpMessage samlSpMessage = null;

		try {
			samlSpMessage = (SamlSpMessage)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = samlSpMessage.getPrimaryKey();

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
	public void resetOriginalValues() {
		SamlSpMessageModelImpl samlSpMessageModelImpl = this;

		samlSpMessageModelImpl._originalSamlIdpEntityId = samlSpMessageModelImpl._samlIdpEntityId;

		samlSpMessageModelImpl._originalSamlIdpResponseKey = samlSpMessageModelImpl._samlIdpResponseKey;

		samlSpMessageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SamlSpMessage> toCacheModel() {
		SamlSpMessageCacheModel samlSpMessageCacheModel = new SamlSpMessageCacheModel();

		samlSpMessageCacheModel.samlSpMessageId = getSamlSpMessageId();

		samlSpMessageCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			samlSpMessageCacheModel.createDate = createDate.getTime();
		}
		else {
			samlSpMessageCacheModel.createDate = Long.MIN_VALUE;
		}

		samlSpMessageCacheModel.samlIdpEntityId = getSamlIdpEntityId();

		String samlIdpEntityId = samlSpMessageCacheModel.samlIdpEntityId;

		if ((samlIdpEntityId != null) && (samlIdpEntityId.length() == 0)) {
			samlSpMessageCacheModel.samlIdpEntityId = null;
		}

		samlSpMessageCacheModel.samlIdpResponseKey = getSamlIdpResponseKey();

		String samlIdpResponseKey = samlSpMessageCacheModel.samlIdpResponseKey;

		if ((samlIdpResponseKey != null) && (samlIdpResponseKey.length() == 0)) {
			samlSpMessageCacheModel.samlIdpResponseKey = null;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			samlSpMessageCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			samlSpMessageCacheModel.expirationDate = Long.MIN_VALUE;
		}

		return samlSpMessageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{samlSpMessageId=");
		sb.append(getSamlSpMessageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", samlIdpEntityId=");
		sb.append(getSamlIdpEntityId());
		sb.append(", samlIdpResponseKey=");
		sb.append(getSamlIdpResponseKey());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.saml.model.SamlSpMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>samlSpMessageId</column-name><column-value><![CDATA[");
		sb.append(getSamlSpMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>samlIdpEntityId</column-name><column-value><![CDATA[");
		sb.append(getSamlIdpEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>samlIdpResponseKey</column-name><column-value><![CDATA[");
		sb.append(getSamlIdpResponseKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SamlSpMessage.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SamlSpMessage.class
		};
	private long _samlSpMessageId;
	private long _companyId;
	private Date _createDate;
	private String _samlIdpEntityId;
	private String _originalSamlIdpEntityId;
	private String _samlIdpResponseKey;
	private String _originalSamlIdpResponseKey;
	private Date _expirationDate;
	private long _columnBitmask;
	private SamlSpMessage _escapedModelProxy;
}