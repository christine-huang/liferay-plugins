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

package com.liferay.portal.workflow.kaleo.designer.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition;
import com.liferay.portal.workflow.kaleo.designer.service.KaleoDraftDefinitionLocalService;
import com.liferay.portal.workflow.kaleo.designer.service.KaleoDraftDefinitionService;
import com.liferay.portal.workflow.kaleo.designer.service.persistence.KaleoDraftDefinitionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the kaleo draft definition local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.workflow.kaleo.designer.service.impl.KaleoDraftDefinitionLocalServiceImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see com.liferay.portal.workflow.kaleo.designer.service.impl.KaleoDraftDefinitionLocalServiceImpl
 * @see com.liferay.portal.workflow.kaleo.designer.service.KaleoDraftDefinitionLocalServiceUtil
 * @generated
 */
public abstract class KaleoDraftDefinitionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements KaleoDraftDefinitionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portal.workflow.kaleo.designer.service.KaleoDraftDefinitionLocalServiceUtil} to access the kaleo draft definition local service.
	 */

	/**
	 * Adds the kaleo draft definition to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoDraftDefinition the kaleo draft definition
	 * @return the kaleo draft definition that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public KaleoDraftDefinition addKaleoDraftDefinition(
		KaleoDraftDefinition kaleoDraftDefinition) throws SystemException {
		kaleoDraftDefinition.setNew(true);

		return kaleoDraftDefinitionPersistence.update(kaleoDraftDefinition);
	}

	/**
	 * Creates a new kaleo draft definition with the primary key. Does not add the kaleo draft definition to the database.
	 *
	 * @param kaleoDraftDefinitionId the primary key for the new kaleo draft definition
	 * @return the new kaleo draft definition
	 */
	public KaleoDraftDefinition createKaleoDraftDefinition(
		long kaleoDraftDefinitionId) {
		return kaleoDraftDefinitionPersistence.create(kaleoDraftDefinitionId);
	}

	/**
	 * Deletes the kaleo draft definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoDraftDefinitionId the primary key of the kaleo draft definition
	 * @return the kaleo draft definition that was removed
	 * @throws PortalException if a kaleo draft definition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public KaleoDraftDefinition deleteKaleoDraftDefinition(
		long kaleoDraftDefinitionId) throws PortalException, SystemException {
		return kaleoDraftDefinitionPersistence.remove(kaleoDraftDefinitionId);
	}

	/**
	 * Deletes the kaleo draft definition from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoDraftDefinition the kaleo draft definition
	 * @return the kaleo draft definition that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public KaleoDraftDefinition deleteKaleoDraftDefinition(
		KaleoDraftDefinition kaleoDraftDefinition) throws SystemException {
		return kaleoDraftDefinitionPersistence.remove(kaleoDraftDefinition);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(KaleoDraftDefinition.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return kaleoDraftDefinitionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return kaleoDraftDefinitionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return kaleoDraftDefinitionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return kaleoDraftDefinitionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public KaleoDraftDefinition fetchKaleoDraftDefinition(
		long kaleoDraftDefinitionId) throws SystemException {
		return kaleoDraftDefinitionPersistence.fetchByPrimaryKey(kaleoDraftDefinitionId);
	}

	/**
	 * Returns the kaleo draft definition with the primary key.
	 *
	 * @param kaleoDraftDefinitionId the primary key of the kaleo draft definition
	 * @return the kaleo draft definition
	 * @throws PortalException if a kaleo draft definition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public KaleoDraftDefinition getKaleoDraftDefinition(
		long kaleoDraftDefinitionId) throws PortalException, SystemException {
		return kaleoDraftDefinitionPersistence.findByPrimaryKey(kaleoDraftDefinitionId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return kaleoDraftDefinitionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the kaleo draft definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo draft definitions
	 * @param end the upper bound of the range of kaleo draft definitions (not inclusive)
	 * @return the range of kaleo draft definitions
	 * @throws SystemException if a system exception occurred
	 */
	public List<KaleoDraftDefinition> getKaleoDraftDefinitions(int start,
		int end) throws SystemException {
		return kaleoDraftDefinitionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of kaleo draft definitions.
	 *
	 * @return the number of kaleo draft definitions
	 * @throws SystemException if a system exception occurred
	 */
	public int getKaleoDraftDefinitionsCount() throws SystemException {
		return kaleoDraftDefinitionPersistence.countAll();
	}

	/**
	 * Updates the kaleo draft definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoDraftDefinition the kaleo draft definition
	 * @return the kaleo draft definition that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public KaleoDraftDefinition updateKaleoDraftDefinition(
		KaleoDraftDefinition kaleoDraftDefinition) throws SystemException {
		return kaleoDraftDefinitionPersistence.update(kaleoDraftDefinition);
	}

	/**
	 * Returns the kaleo draft definition local service.
	 *
	 * @return the kaleo draft definition local service
	 */
	public KaleoDraftDefinitionLocalService getKaleoDraftDefinitionLocalService() {
		return kaleoDraftDefinitionLocalService;
	}

	/**
	 * Sets the kaleo draft definition local service.
	 *
	 * @param kaleoDraftDefinitionLocalService the kaleo draft definition local service
	 */
	public void setKaleoDraftDefinitionLocalService(
		KaleoDraftDefinitionLocalService kaleoDraftDefinitionLocalService) {
		this.kaleoDraftDefinitionLocalService = kaleoDraftDefinitionLocalService;
	}

	/**
	 * Returns the kaleo draft definition remote service.
	 *
	 * @return the kaleo draft definition remote service
	 */
	public KaleoDraftDefinitionService getKaleoDraftDefinitionService() {
		return kaleoDraftDefinitionService;
	}

	/**
	 * Sets the kaleo draft definition remote service.
	 *
	 * @param kaleoDraftDefinitionService the kaleo draft definition remote service
	 */
	public void setKaleoDraftDefinitionService(
		KaleoDraftDefinitionService kaleoDraftDefinitionService) {
		this.kaleoDraftDefinitionService = kaleoDraftDefinitionService;
	}

	/**
	 * Returns the kaleo draft definition persistence.
	 *
	 * @return the kaleo draft definition persistence
	 */
	public KaleoDraftDefinitionPersistence getKaleoDraftDefinitionPersistence() {
		return kaleoDraftDefinitionPersistence;
	}

	/**
	 * Sets the kaleo draft definition persistence.
	 *
	 * @param kaleoDraftDefinitionPersistence the kaleo draft definition persistence
	 */
	public void setKaleoDraftDefinitionPersistence(
		KaleoDraftDefinitionPersistence kaleoDraftDefinitionPersistence) {
		this.kaleoDraftDefinitionPersistence = kaleoDraftDefinitionPersistence;
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

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition",
			kaleoDraftDefinitionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition");
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
		return KaleoDraftDefinition.class;
	}

	protected String getModelClassName() {
		return KaleoDraftDefinition.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = kaleoDraftDefinitionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = KaleoDraftDefinitionLocalService.class)
	protected KaleoDraftDefinitionLocalService kaleoDraftDefinitionLocalService;
	@BeanReference(type = KaleoDraftDefinitionService.class)
	protected KaleoDraftDefinitionService kaleoDraftDefinitionService;
	@BeanReference(type = KaleoDraftDefinitionPersistence.class)
	protected KaleoDraftDefinitionPersistence kaleoDraftDefinitionPersistence;
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
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private KaleoDraftDefinitionLocalServiceClpInvoker _clpInvoker = new KaleoDraftDefinitionLocalServiceClpInvoker();
}