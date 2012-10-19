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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Mika Koivisto
 * @generated
 */
public class SamlIdpSpConnectionSoap implements Serializable {
	public static SamlIdpSpConnectionSoap toSoapModel(SamlIdpSpConnection model) {
		SamlIdpSpConnectionSoap soapModel = new SamlIdpSpConnectionSoap();

		soapModel.setSamlIdpSpConnectionId(model.getSamlIdpSpConnectionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSamlSpEntityId(model.getSamlSpEntityId());
		soapModel.setAssertionLifetime(model.getAssertionLifetime());
		soapModel.setAttributeNames(model.getAttributeNames());
		soapModel.setAttributesEnabled(model.getAttributesEnabled());
		soapModel.setAttributesNamespaceEnabled(model.getAttributesNamespaceEnabled());
		soapModel.setEnabled(model.getEnabled());
		soapModel.setMetadataUrl(model.getMetadataUrl());
		soapModel.setMetadataXml(model.getMetadataXml());
		soapModel.setMetadataUpdatedDate(model.getMetadataUpdatedDate());
		soapModel.setName(model.getName());
		soapModel.setNameIdAttribute(model.getNameIdAttribute());
		soapModel.setNameIdFormat(model.getNameIdFormat());

		return soapModel;
	}

	public static SamlIdpSpConnectionSoap[] toSoapModels(
		SamlIdpSpConnection[] models) {
		SamlIdpSpConnectionSoap[] soapModels = new SamlIdpSpConnectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SamlIdpSpConnectionSoap[][] toSoapModels(
		SamlIdpSpConnection[][] models) {
		SamlIdpSpConnectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SamlIdpSpConnectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SamlIdpSpConnectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SamlIdpSpConnectionSoap[] toSoapModels(
		List<SamlIdpSpConnection> models) {
		List<SamlIdpSpConnectionSoap> soapModels = new ArrayList<SamlIdpSpConnectionSoap>(models.size());

		for (SamlIdpSpConnection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SamlIdpSpConnectionSoap[soapModels.size()]);
	}

	public SamlIdpSpConnectionSoap() {
	}

	public long getPrimaryKey() {
		return _samlIdpSpConnectionId;
	}

	public void setPrimaryKey(long pk) {
		setSamlIdpSpConnectionId(pk);
	}

	public long getSamlIdpSpConnectionId() {
		return _samlIdpSpConnectionId;
	}

	public void setSamlIdpSpConnectionId(long samlIdpSpConnectionId) {
		_samlIdpSpConnectionId = samlIdpSpConnectionId;
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

	public String getSamlSpEntityId() {
		return _samlSpEntityId;
	}

	public void setSamlSpEntityId(String samlSpEntityId) {
		_samlSpEntityId = samlSpEntityId;
	}

	public int getAssertionLifetime() {
		return _assertionLifetime;
	}

	public void setAssertionLifetime(int assertionLifetime) {
		_assertionLifetime = assertionLifetime;
	}

	public String getAttributeNames() {
		return _attributeNames;
	}

	public void setAttributeNames(String attributeNames) {
		_attributeNames = attributeNames;
	}

	public boolean getAttributesEnabled() {
		return _attributesEnabled;
	}

	public boolean isAttributesEnabled() {
		return _attributesEnabled;
	}

	public void setAttributesEnabled(boolean attributesEnabled) {
		_attributesEnabled = attributesEnabled;
	}

	public boolean getAttributesNamespaceEnabled() {
		return _attributesNamespaceEnabled;
	}

	public boolean isAttributesNamespaceEnabled() {
		return _attributesNamespaceEnabled;
	}

	public void setAttributesNamespaceEnabled(
		boolean attributesNamespaceEnabled) {
		_attributesNamespaceEnabled = attributesNamespaceEnabled;
	}

	public boolean getEnabled() {
		return _enabled;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	public String getMetadataUrl() {
		return _metadataUrl;
	}

	public void setMetadataUrl(String metadataUrl) {
		_metadataUrl = metadataUrl;
	}

	public String getMetadataXml() {
		return _metadataXml;
	}

	public void setMetadataXml(String metadataXml) {
		_metadataXml = metadataXml;
	}

	public Date getMetadataUpdatedDate() {
		return _metadataUpdatedDate;
	}

	public void setMetadataUpdatedDate(Date metadataUpdatedDate) {
		_metadataUpdatedDate = metadataUpdatedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getNameIdAttribute() {
		return _nameIdAttribute;
	}

	public void setNameIdAttribute(String nameIdAttribute) {
		_nameIdAttribute = nameIdAttribute;
	}

	public String getNameIdFormat() {
		return _nameIdFormat;
	}

	public void setNameIdFormat(String nameIdFormat) {
		_nameIdFormat = nameIdFormat;
	}

	private long _samlIdpSpConnectionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _samlSpEntityId;
	private int _assertionLifetime;
	private String _attributeNames;
	private boolean _attributesEnabled;
	private boolean _attributesNamespaceEnabled;
	private boolean _enabled;
	private String _metadataUrl;
	private String _metadataXml;
	private Date _metadataUpdatedDate;
	private String _name;
	private String _nameIdAttribute;
	private String _nameIdFormat;
}