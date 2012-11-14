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

package com.liferay.socialcoding.model.impl;

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

import com.liferay.socialcoding.model.SVNRevision;
import com.liferay.socialcoding.model.SVNRevisionModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SVNRevision service. Represents a row in the &quot;SC_SVNRevision&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.socialcoding.model.SVNRevisionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SVNRevisionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SVNRevisionImpl
 * @see com.liferay.socialcoding.model.SVNRevision
 * @see com.liferay.socialcoding.model.SVNRevisionModel
 * @generated
 */
public class SVNRevisionModelImpl extends BaseModelImpl<SVNRevision>
	implements SVNRevisionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s v n revision model instance should use the {@link com.liferay.socialcoding.model.SVNRevision} interface instead.
	 */
	public static final String TABLE_NAME = "SC_SVNRevision";
	public static final Object[][] TABLE_COLUMNS = {
			{ "svnRevisionId", Types.BIGINT },
			{ "svnUserId", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "svnRepositoryId", Types.BIGINT },
			{ "revisionNumber", Types.BIGINT },
			{ "comments", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SC_SVNRevision (svnRevisionId LONG not null primary key,svnUserId VARCHAR(75) null,createDate DATE null,svnRepositoryId LONG,revisionNumber LONG,comments STRING null)";
	public static final String TABLE_SQL_DROP = "drop table SC_SVNRevision";
	public static final String ORDER_BY_JPQL = " ORDER BY svnRevision.revisionNumber DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SC_SVNRevision.revisionNumber DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.socialcoding.model.SVNRevision"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.socialcoding.model.SVNRevision"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.socialcoding.model.SVNRevision"),
			true);
	public static long SVNREPOSITORYID_COLUMN_BITMASK = 1L;
	public static long SVNUSERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.socialcoding.model.SVNRevision"));

	public SVNRevisionModelImpl() {
	}

	public long getPrimaryKey() {
		return _svnRevisionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSvnRevisionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_svnRevisionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return SVNRevision.class;
	}

	public String getModelClassName() {
		return SVNRevision.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("svnRevisionId", getSvnRevisionId());
		attributes.put("svnUserId", getSvnUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("svnRepositoryId", getSvnRepositoryId());
		attributes.put("revisionNumber", getRevisionNumber());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long svnRevisionId = (Long)attributes.get("svnRevisionId");

		if (svnRevisionId != null) {
			setSvnRevisionId(svnRevisionId);
		}

		String svnUserId = (String)attributes.get("svnUserId");

		if (svnUserId != null) {
			setSvnUserId(svnUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long svnRepositoryId = (Long)attributes.get("svnRepositoryId");

		if (svnRepositoryId != null) {
			setSvnRepositoryId(svnRepositoryId);
		}

		Long revisionNumber = (Long)attributes.get("revisionNumber");

		if (revisionNumber != null) {
			setRevisionNumber(revisionNumber);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	public long getSvnRevisionId() {
		return _svnRevisionId;
	}

	public void setSvnRevisionId(long svnRevisionId) {
		_svnRevisionId = svnRevisionId;
	}

	public String getSvnUserId() {
		if (_svnUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _svnUserId;
		}
	}

	public void setSvnUserId(String svnUserId) {
		_columnBitmask |= SVNUSERID_COLUMN_BITMASK;

		if (_originalSvnUserId == null) {
			_originalSvnUserId = _svnUserId;
		}

		_svnUserId = svnUserId;
	}

	public String getOriginalSvnUserId() {
		return GetterUtil.getString(_originalSvnUserId);
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getSvnRepositoryId() {
		return _svnRepositoryId;
	}

	public void setSvnRepositoryId(long svnRepositoryId) {
		_columnBitmask |= SVNREPOSITORYID_COLUMN_BITMASK;

		if (!_setOriginalSvnRepositoryId) {
			_setOriginalSvnRepositoryId = true;

			_originalSvnRepositoryId = _svnRepositoryId;
		}

		_svnRepositoryId = svnRepositoryId;
	}

	public long getOriginalSvnRepositoryId() {
		return _originalSvnRepositoryId;
	}

	public long getRevisionNumber() {
		return _revisionNumber;
	}

	public void setRevisionNumber(long revisionNumber) {
		_columnBitmask = -1L;

		_revisionNumber = revisionNumber;
	}

	public String getComments() {
		if (_comments == null) {
			return StringPool.BLANK;
		}
		else {
			return _comments;
		}
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SVNRevision.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SVNRevision toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SVNRevision)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public SVNRevision toUnescapedModel() {
		if (ProxyUtil.isProxyClass(getClass())) {
			InvocationHandler invocationHandler = ProxyUtil.getInvocationHandler(this);

			AutoEscapeBeanHandler autoEscapeBeanHandler = (AutoEscapeBeanHandler)invocationHandler;

			_unescapedModel = (SVNRevision)autoEscapeBeanHandler.getBean();
		}
		else {
			_unescapedModel = (SVNRevision)this;
		}

		return _unescapedModel;
	}

	@Override
	public Object clone() {
		SVNRevisionImpl svnRevisionImpl = new SVNRevisionImpl();

		svnRevisionImpl.setSvnRevisionId(getSvnRevisionId());
		svnRevisionImpl.setSvnUserId(getSvnUserId());
		svnRevisionImpl.setCreateDate(getCreateDate());
		svnRevisionImpl.setSvnRepositoryId(getSvnRepositoryId());
		svnRevisionImpl.setRevisionNumber(getRevisionNumber());
		svnRevisionImpl.setComments(getComments());

		svnRevisionImpl.resetOriginalValues();

		return svnRevisionImpl;
	}

	public int compareTo(SVNRevision svnRevision) {
		int value = 0;

		if (getRevisionNumber() < svnRevision.getRevisionNumber()) {
			value = -1;
		}
		else if (getRevisionNumber() > svnRevision.getRevisionNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SVNRevision svnRevision = null;

		try {
			svnRevision = (SVNRevision)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = svnRevision.getPrimaryKey();

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
		SVNRevisionModelImpl svnRevisionModelImpl = this;

		svnRevisionModelImpl._originalSvnUserId = svnRevisionModelImpl._svnUserId;

		svnRevisionModelImpl._originalSvnRepositoryId = svnRevisionModelImpl._svnRepositoryId;

		svnRevisionModelImpl._setOriginalSvnRepositoryId = false;

		svnRevisionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SVNRevision> toCacheModel() {
		SVNRevisionCacheModel svnRevisionCacheModel = new SVNRevisionCacheModel();

		svnRevisionCacheModel.svnRevisionId = getSvnRevisionId();

		svnRevisionCacheModel.svnUserId = getSvnUserId();

		String svnUserId = svnRevisionCacheModel.svnUserId;

		if ((svnUserId != null) && (svnUserId.length() == 0)) {
			svnRevisionCacheModel.svnUserId = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			svnRevisionCacheModel.createDate = createDate.getTime();
		}
		else {
			svnRevisionCacheModel.createDate = Long.MIN_VALUE;
		}

		svnRevisionCacheModel.svnRepositoryId = getSvnRepositoryId();

		svnRevisionCacheModel.revisionNumber = getRevisionNumber();

		svnRevisionCacheModel.comments = getComments();

		String comments = svnRevisionCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			svnRevisionCacheModel.comments = null;
		}

		return svnRevisionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{svnRevisionId=");
		sb.append(getSvnRevisionId());
		sb.append(", svnUserId=");
		sb.append(getSvnUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", svnRepositoryId=");
		sb.append(getSvnRepositoryId());
		sb.append(", revisionNumber=");
		sb.append(getRevisionNumber());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.socialcoding.model.SVNRevision");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>svnRevisionId</column-name><column-value><![CDATA[");
		sb.append(getSvnRevisionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>svnUserId</column-name><column-value><![CDATA[");
		sb.append(getSvnUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>svnRepositoryId</column-name><column-value><![CDATA[");
		sb.append(getSvnRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>revisionNumber</column-name><column-value><![CDATA[");
		sb.append(getRevisionNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SVNRevision.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SVNRevision.class
		};
	private long _svnRevisionId;
	private String _svnUserId;
	private String _originalSvnUserId;
	private Date _createDate;
	private long _svnRepositoryId;
	private long _originalSvnRepositoryId;
	private boolean _setOriginalSvnRepositoryId;
	private long _revisionNumber;
	private String _comments;
	private long _columnBitmask;
	private SVNRevision _escapedModel;
	private SVNRevision _unescapedModel;
}