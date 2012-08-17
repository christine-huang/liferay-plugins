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

package com.liferay.saml;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.saml.model.SamlIdpSpSession;

import java.io.Serializable;

import org.joda.time.DateTime;

import org.opensaml.saml2.core.StatusCode;

/**
 * @author Mika Koivisto
 */
public class SamlSloRequestInfo implements Serializable {
	public static final int REQUEST_STATUS_FAILED = 3;
	public static final int REQUEST_STATUS_INITIATED = 1;
	public static final int REQUEST_STATUS_PENDING = 0;
	public static final int REQUEST_STATUS_SUCCESS = 2;
	public static final int REQUEST_STATUS_TIMED_OUT = 5;
	public static final int REQUEST_STATUS_UNSUPPORTED = 4;

	public SamlSloRequestInfo(SamlIdpSpSession spSession) {
		_spSession = spSession;
	}

	public String getEntityId() {
		return _spSession.getSamlSpEntityId();
	}

	public DateTime getInitiateTime() {
		return _initiateTime;
	}

	public SamlIdpSpSession getSamlIdpSpSession() {
		return _spSession;
	}

	public int getStatus() {
		return _status;
	}

	public String getStatusCode() {
		return _statusCode;
	}

	public void setInitiateTime(DateTime initiateTime) {
		_initiateTime = initiateTime;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public void setStatusCode(String statusCode) {
		if (statusCode.equals(StatusCode.SUCCESS_URI)) {
			_status = REQUEST_STATUS_SUCCESS;
		}
		else {
			_status = REQUEST_STATUS_FAILED;
		}

		_statusCode = statusCode;
	}

	public JSONObject toJSONObject() {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("entityId", getEntityId());
		jsonObject.put("name", getEntityId());
		jsonObject.put("status", getStatus());
		jsonObject.put("statusCode", getStatusCode());

		if (getInitiateTime() != null) {
			jsonObject.put("initiateTime", getInitiateTime().toDate());
		}

		return jsonObject;
	}

	private DateTime _initiateTime;
	private SamlIdpSpSession _spSession;
	private int _status;
	private String _statusCode;

}