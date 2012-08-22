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

package com.liferay.portal.workflow.kaleo.forms.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLinkLocalService;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLinkService;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLocalService;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessService;
import com.liferay.portal.workflow.kaleo.forms.service.persistence.KaleoProcessLinkPersistence;
import com.liferay.portal.workflow.kaleo.forms.service.persistence.KaleoProcessPersistence;

import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalService;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordService;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalService;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetService;
import com.liferay.portlet.dynamicdatalists.service.persistence.DDLRecordPersistence;
import com.liferay.portlet.dynamicdatalists.service.persistence.DDLRecordSetPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the kaleo process remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.workflow.kaleo.forms.service.impl.KaleoProcessServiceImpl}.
 * </p>
 *
 * @author Marcellus Tavares
 * @see com.liferay.portal.workflow.kaleo.forms.service.impl.KaleoProcessServiceImpl
 * @see com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessServiceUtil
 * @generated
 */
public abstract class KaleoProcessServiceBaseImpl extends BaseServiceImpl
	implements KaleoProcessService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessServiceUtil} to access the kaleo process remote service.
	 */

	/**
	 * Returns the kaleo process local service.
	 *
	 * @return the kaleo process local service
	 */
	public KaleoProcessLocalService getKaleoProcessLocalService() {
		return kaleoProcessLocalService;
	}

	/**
	 * Sets the kaleo process local service.
	 *
	 * @param kaleoProcessLocalService the kaleo process local service
	 */
	public void setKaleoProcessLocalService(
		KaleoProcessLocalService kaleoProcessLocalService) {
		this.kaleoProcessLocalService = kaleoProcessLocalService;
	}

	/**
	 * Returns the kaleo process remote service.
	 *
	 * @return the kaleo process remote service
	 */
	public KaleoProcessService getKaleoProcessService() {
		return kaleoProcessService;
	}

	/**
	 * Sets the kaleo process remote service.
	 *
	 * @param kaleoProcessService the kaleo process remote service
	 */
	public void setKaleoProcessService(KaleoProcessService kaleoProcessService) {
		this.kaleoProcessService = kaleoProcessService;
	}

	/**
	 * Returns the kaleo process persistence.
	 *
	 * @return the kaleo process persistence
	 */
	public KaleoProcessPersistence getKaleoProcessPersistence() {
		return kaleoProcessPersistence;
	}

	/**
	 * Sets the kaleo process persistence.
	 *
	 * @param kaleoProcessPersistence the kaleo process persistence
	 */
	public void setKaleoProcessPersistence(
		KaleoProcessPersistence kaleoProcessPersistence) {
		this.kaleoProcessPersistence = kaleoProcessPersistence;
	}

	/**
	 * Returns the kaleo process link local service.
	 *
	 * @return the kaleo process link local service
	 */
	public KaleoProcessLinkLocalService getKaleoProcessLinkLocalService() {
		return kaleoProcessLinkLocalService;
	}

	/**
	 * Sets the kaleo process link local service.
	 *
	 * @param kaleoProcessLinkLocalService the kaleo process link local service
	 */
	public void setKaleoProcessLinkLocalService(
		KaleoProcessLinkLocalService kaleoProcessLinkLocalService) {
		this.kaleoProcessLinkLocalService = kaleoProcessLinkLocalService;
	}

	/**
	 * Returns the kaleo process link remote service.
	 *
	 * @return the kaleo process link remote service
	 */
	public KaleoProcessLinkService getKaleoProcessLinkService() {
		return kaleoProcessLinkService;
	}

	/**
	 * Sets the kaleo process link remote service.
	 *
	 * @param kaleoProcessLinkService the kaleo process link remote service
	 */
	public void setKaleoProcessLinkService(
		KaleoProcessLinkService kaleoProcessLinkService) {
		this.kaleoProcessLinkService = kaleoProcessLinkService;
	}

	/**
	 * Returns the kaleo process link persistence.
	 *
	 * @return the kaleo process link persistence
	 */
	public KaleoProcessLinkPersistence getKaleoProcessLinkPersistence() {
		return kaleoProcessLinkPersistence;
	}

	/**
	 * Sets the kaleo process link persistence.
	 *
	 * @param kaleoProcessLinkPersistence the kaleo process link persistence
	 */
	public void setKaleoProcessLinkPersistence(
		KaleoProcessLinkPersistence kaleoProcessLinkPersistence) {
		this.kaleoProcessLinkPersistence = kaleoProcessLinkPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the workflow instance link local service.
	 *
	 * @return the workflow instance link local service
	 */
	public WorkflowInstanceLinkLocalService getWorkflowInstanceLinkLocalService() {
		return workflowInstanceLinkLocalService;
	}

	/**
	 * Sets the workflow instance link local service.
	 *
	 * @param workflowInstanceLinkLocalService the workflow instance link local service
	 */
	public void setWorkflowInstanceLinkLocalService(
		WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
		this.workflowInstanceLinkLocalService = workflowInstanceLinkLocalService;
	}

	/**
	 * Returns the workflow instance link persistence.
	 *
	 * @return the workflow instance link persistence
	 */
	public WorkflowInstanceLinkPersistence getWorkflowInstanceLinkPersistence() {
		return workflowInstanceLinkPersistence;
	}

	/**
	 * Sets the workflow instance link persistence.
	 *
	 * @param workflowInstanceLinkPersistence the workflow instance link persistence
	 */
	public void setWorkflowInstanceLinkPersistence(
		WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence) {
		this.workflowInstanceLinkPersistence = workflowInstanceLinkPersistence;
	}

	/**
	 * Returns the d d l record local service.
	 *
	 * @return the d d l record local service
	 */
	public DDLRecordLocalService getDDLRecordLocalService() {
		return ddlRecordLocalService;
	}

	/**
	 * Sets the d d l record local service.
	 *
	 * @param ddlRecordLocalService the d d l record local service
	 */
	public void setDDLRecordLocalService(
		DDLRecordLocalService ddlRecordLocalService) {
		this.ddlRecordLocalService = ddlRecordLocalService;
	}

	/**
	 * Returns the d d l record remote service.
	 *
	 * @return the d d l record remote service
	 */
	public DDLRecordService getDDLRecordService() {
		return ddlRecordService;
	}

	/**
	 * Sets the d d l record remote service.
	 *
	 * @param ddlRecordService the d d l record remote service
	 */
	public void setDDLRecordService(DDLRecordService ddlRecordService) {
		this.ddlRecordService = ddlRecordService;
	}

	/**
	 * Returns the d d l record persistence.
	 *
	 * @return the d d l record persistence
	 */
	public DDLRecordPersistence getDDLRecordPersistence() {
		return ddlRecordPersistence;
	}

	/**
	 * Sets the d d l record persistence.
	 *
	 * @param ddlRecordPersistence the d d l record persistence
	 */
	public void setDDLRecordPersistence(
		DDLRecordPersistence ddlRecordPersistence) {
		this.ddlRecordPersistence = ddlRecordPersistence;
	}

	/**
	 * Returns the d d l record set local service.
	 *
	 * @return the d d l record set local service
	 */
	public DDLRecordSetLocalService getDDLRecordSetLocalService() {
		return ddlRecordSetLocalService;
	}

	/**
	 * Sets the d d l record set local service.
	 *
	 * @param ddlRecordSetLocalService the d d l record set local service
	 */
	public void setDDLRecordSetLocalService(
		DDLRecordSetLocalService ddlRecordSetLocalService) {
		this.ddlRecordSetLocalService = ddlRecordSetLocalService;
	}

	/**
	 * Returns the d d l record set remote service.
	 *
	 * @return the d d l record set remote service
	 */
	public DDLRecordSetService getDDLRecordSetService() {
		return ddlRecordSetService;
	}

	/**
	 * Sets the d d l record set remote service.
	 *
	 * @param ddlRecordSetService the d d l record set remote service
	 */
	public void setDDLRecordSetService(DDLRecordSetService ddlRecordSetService) {
		this.ddlRecordSetService = ddlRecordSetService;
	}

	/**
	 * Returns the d d l record set persistence.
	 *
	 * @return the d d l record set persistence
	 */
	public DDLRecordSetPersistence getDDLRecordSetPersistence() {
		return ddlRecordSetPersistence;
	}

	/**
	 * Sets the d d l record set persistence.
	 *
	 * @param ddlRecordSetPersistence the d d l record set persistence
	 */
	public void setDDLRecordSetPersistence(
		DDLRecordSetPersistence ddlRecordSetPersistence) {
		this.ddlRecordSetPersistence = ddlRecordSetPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return KaleoProcess.class;
	}

	protected String getModelClassName() {
		return KaleoProcess.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = kaleoProcessPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = KaleoProcessLocalService.class)
	protected KaleoProcessLocalService kaleoProcessLocalService;
	@BeanReference(type = KaleoProcessService.class)
	protected KaleoProcessService kaleoProcessService;
	@BeanReference(type = KaleoProcessPersistence.class)
	protected KaleoProcessPersistence kaleoProcessPersistence;
	@BeanReference(type = KaleoProcessLinkLocalService.class)
	protected KaleoProcessLinkLocalService kaleoProcessLinkLocalService;
	@BeanReference(type = KaleoProcessLinkService.class)
	protected KaleoProcessLinkService kaleoProcessLinkService;
	@BeanReference(type = KaleoProcessLinkPersistence.class)
	protected KaleoProcessLinkPersistence kaleoProcessLinkPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = WorkflowInstanceLinkLocalService.class)
	protected WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	@BeanReference(type = DDLRecordLocalService.class)
	protected DDLRecordLocalService ddlRecordLocalService;
	@BeanReference(type = DDLRecordService.class)
	protected DDLRecordService ddlRecordService;
	@BeanReference(type = DDLRecordPersistence.class)
	protected DDLRecordPersistence ddlRecordPersistence;
	@BeanReference(type = DDLRecordSetLocalService.class)
	protected DDLRecordSetLocalService ddlRecordSetLocalService;
	@BeanReference(type = DDLRecordSetService.class)
	protected DDLRecordSetService ddlRecordSetService;
	@BeanReference(type = DDLRecordSetPersistence.class)
	protected DDLRecordSetPersistence ddlRecordSetPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private KaleoProcessServiceClpInvoker _clpInvoker = new KaleoProcessServiceClpInvoker();
}