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

package com.liferay.salesforce.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SalesforceAccountLocalService}.
 * </p>
 *
 * @author    Michael C. Han
 * @see       SalesforceAccountLocalService
 * @generated
 */
public class SalesforceAccountLocalServiceWrapper
	implements SalesforceAccountLocalService,
		ServiceWrapper<SalesforceAccountLocalService> {
	public SalesforceAccountLocalServiceWrapper(
		SalesforceAccountLocalService salesforceAccountLocalService) {
		_salesforceAccountLocalService = salesforceAccountLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _salesforceAccountLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_salesforceAccountLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _salesforceAccountLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public com.liferay.portal.kernel.messaging.MessageBatch getAccountsByName(
		long companyId, java.lang.String name,
		java.util.List<java.lang.String> fieldNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getAccountsByName(companyId,
			name, fieldNames);
	}

	public com.liferay.portal.kernel.messaging.MessageBatch getAccountsByOwnerId(
		long companyId, java.lang.String ownerId,
		java.util.List<java.lang.String> fieldNames)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getAccountsByOwnerId(companyId,
			ownerId, fieldNames);
	}

	public com.liferay.portal.kernel.messaging.MessageBatch getAccountsByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getAccountsByUserName(companyId,
			userName, fieldNames);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SalesforceAccountLocalService getWrappedSalesforceAccountLocalService() {
		return _salesforceAccountLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSalesforceAccountLocalService(
		SalesforceAccountLocalService salesforceAccountLocalService) {
		_salesforceAccountLocalService = salesforceAccountLocalService;
	}

	public SalesforceAccountLocalService getWrappedService() {
		return _salesforceAccountLocalService;
	}

	public void setWrappedService(
		SalesforceAccountLocalService salesforceAccountLocalService) {
		_salesforceAccountLocalService = salesforceAccountLocalService;
	}

	private SalesforceAccountLocalService _salesforceAccountLocalService;
}