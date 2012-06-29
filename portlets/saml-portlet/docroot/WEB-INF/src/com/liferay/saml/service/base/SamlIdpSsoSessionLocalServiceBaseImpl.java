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

package com.liferay.saml.service.base;

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
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.saml.model.SamlIdpSsoSession;
import com.liferay.saml.service.SamlIdpSpSessionLocalService;
import com.liferay.saml.service.SamlIdpSsoSessionLocalService;
import com.liferay.saml.service.SamlSpAuthRequestLocalService;
import com.liferay.saml.service.SamlSpMessageLocalService;
import com.liferay.saml.service.SamlSpSessionLocalService;
import com.liferay.saml.service.persistence.SamlIdpSpSessionPersistence;
import com.liferay.saml.service.persistence.SamlIdpSsoSessionPersistence;
import com.liferay.saml.service.persistence.SamlSpAuthRequestPersistence;
import com.liferay.saml.service.persistence.SamlSpMessagePersistence;
import com.liferay.saml.service.persistence.SamlSpSessionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the saml idp sso session local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.saml.service.impl.SamlIdpSsoSessionLocalServiceImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see com.liferay.saml.service.impl.SamlIdpSsoSessionLocalServiceImpl
 * @see com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil
 * @generated
 */
public abstract class SamlIdpSsoSessionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SamlIdpSsoSessionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil} to access the saml idp sso session local service.
	 */

	/**
	 * Adds the saml idp sso session to the database. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSsoSession the saml idp sso session
	 * @return the saml idp sso session that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SamlIdpSsoSession addSamlIdpSsoSession(
		SamlIdpSsoSession samlIdpSsoSession) throws SystemException {
		samlIdpSsoSession.setNew(true);

		return samlIdpSsoSessionPersistence.update(samlIdpSsoSession, false);
	}

	/**
	 * Creates a new saml idp sso session with the primary key. Does not add the saml idp sso session to the database.
	 *
	 * @param samlIdpSsoSessionId the primary key for the new saml idp sso session
	 * @return the new saml idp sso session
	 */
	public SamlIdpSsoSession createSamlIdpSsoSession(long samlIdpSsoSessionId) {
		return samlIdpSsoSessionPersistence.create(samlIdpSsoSessionId);
	}

	/**
	 * Deletes the saml idp sso session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSsoSessionId the primary key of the saml idp sso session
	 * @return the saml idp sso session that was removed
	 * @throws PortalException if a saml idp sso session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public SamlIdpSsoSession deleteSamlIdpSsoSession(long samlIdpSsoSessionId)
		throws PortalException, SystemException {
		return samlIdpSsoSessionPersistence.remove(samlIdpSsoSessionId);
	}

	/**
	 * Deletes the saml idp sso session from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSsoSession the saml idp sso session
	 * @return the saml idp sso session that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public SamlIdpSsoSession deleteSamlIdpSsoSession(
		SamlIdpSsoSession samlIdpSsoSession) throws SystemException {
		return samlIdpSsoSessionPersistence.remove(samlIdpSsoSession);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SamlIdpSsoSession.class,
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
		return samlIdpSsoSessionPersistence.findWithDynamicQuery(dynamicQuery);
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
		return samlIdpSsoSessionPersistence.findWithDynamicQuery(dynamicQuery,
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
		return samlIdpSsoSessionPersistence.findWithDynamicQuery(dynamicQuery,
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
		return samlIdpSsoSessionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public SamlIdpSsoSession fetchSamlIdpSsoSession(long samlIdpSsoSessionId)
		throws SystemException {
		return samlIdpSsoSessionPersistence.fetchByPrimaryKey(samlIdpSsoSessionId);
	}

	/**
	 * Returns the saml idp sso session with the primary key.
	 *
	 * @param samlIdpSsoSessionId the primary key of the saml idp sso session
	 * @return the saml idp sso session
	 * @throws PortalException if a saml idp sso session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSsoSession getSamlIdpSsoSession(long samlIdpSsoSessionId)
		throws PortalException, SystemException {
		return samlIdpSsoSessionPersistence.findByPrimaryKey(samlIdpSsoSessionId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return samlIdpSsoSessionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the saml idp sso sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml idp sso sessions
	 * @param end the upper bound of the range of saml idp sso sessions (not inclusive)
	 * @return the range of saml idp sso sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSsoSession> getSamlIdpSsoSessions(int start, int end)
		throws SystemException {
		return samlIdpSsoSessionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of saml idp sso sessions.
	 *
	 * @return the number of saml idp sso sessions
	 * @throws SystemException if a system exception occurred
	 */
	public int getSamlIdpSsoSessionsCount() throws SystemException {
		return samlIdpSsoSessionPersistence.countAll();
	}

	/**
	 * Updates the saml idp sso session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSsoSession the saml idp sso session
	 * @return the saml idp sso session that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SamlIdpSsoSession updateSamlIdpSsoSession(
		SamlIdpSsoSession samlIdpSsoSession) throws SystemException {
		return updateSamlIdpSsoSession(samlIdpSsoSession, true);
	}

	/**
	 * Updates the saml idp sso session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSsoSession the saml idp sso session
	 * @param merge whether to merge the saml idp sso session with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the saml idp sso session that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SamlIdpSsoSession updateSamlIdpSsoSession(
		SamlIdpSsoSession samlIdpSsoSession, boolean merge)
		throws SystemException {
		samlIdpSsoSession.setNew(false);

		return samlIdpSsoSessionPersistence.update(samlIdpSsoSession, merge);
	}

	/**
	 * Returns the saml idp sp session local service.
	 *
	 * @return the saml idp sp session local service
	 */
	public SamlIdpSpSessionLocalService getSamlIdpSpSessionLocalService() {
		return samlIdpSpSessionLocalService;
	}

	/**
	 * Sets the saml idp sp session local service.
	 *
	 * @param samlIdpSpSessionLocalService the saml idp sp session local service
	 */
	public void setSamlIdpSpSessionLocalService(
		SamlIdpSpSessionLocalService samlIdpSpSessionLocalService) {
		this.samlIdpSpSessionLocalService = samlIdpSpSessionLocalService;
	}

	/**
	 * Returns the saml idp sp session persistence.
	 *
	 * @return the saml idp sp session persistence
	 */
	public SamlIdpSpSessionPersistence getSamlIdpSpSessionPersistence() {
		return samlIdpSpSessionPersistence;
	}

	/**
	 * Sets the saml idp sp session persistence.
	 *
	 * @param samlIdpSpSessionPersistence the saml idp sp session persistence
	 */
	public void setSamlIdpSpSessionPersistence(
		SamlIdpSpSessionPersistence samlIdpSpSessionPersistence) {
		this.samlIdpSpSessionPersistence = samlIdpSpSessionPersistence;
	}

	/**
	 * Returns the saml idp sso session local service.
	 *
	 * @return the saml idp sso session local service
	 */
	public SamlIdpSsoSessionLocalService getSamlIdpSsoSessionLocalService() {
		return samlIdpSsoSessionLocalService;
	}

	/**
	 * Sets the saml idp sso session local service.
	 *
	 * @param samlIdpSsoSessionLocalService the saml idp sso session local service
	 */
	public void setSamlIdpSsoSessionLocalService(
		SamlIdpSsoSessionLocalService samlIdpSsoSessionLocalService) {
		this.samlIdpSsoSessionLocalService = samlIdpSsoSessionLocalService;
	}

	/**
	 * Returns the saml idp sso session persistence.
	 *
	 * @return the saml idp sso session persistence
	 */
	public SamlIdpSsoSessionPersistence getSamlIdpSsoSessionPersistence() {
		return samlIdpSsoSessionPersistence;
	}

	/**
	 * Sets the saml idp sso session persistence.
	 *
	 * @param samlIdpSsoSessionPersistence the saml idp sso session persistence
	 */
	public void setSamlIdpSsoSessionPersistence(
		SamlIdpSsoSessionPersistence samlIdpSsoSessionPersistence) {
		this.samlIdpSsoSessionPersistence = samlIdpSsoSessionPersistence;
	}

	/**
	 * Returns the saml sp auth request local service.
	 *
	 * @return the saml sp auth request local service
	 */
	public SamlSpAuthRequestLocalService getSamlSpAuthRequestLocalService() {
		return samlSpAuthRequestLocalService;
	}

	/**
	 * Sets the saml sp auth request local service.
	 *
	 * @param samlSpAuthRequestLocalService the saml sp auth request local service
	 */
	public void setSamlSpAuthRequestLocalService(
		SamlSpAuthRequestLocalService samlSpAuthRequestLocalService) {
		this.samlSpAuthRequestLocalService = samlSpAuthRequestLocalService;
	}

	/**
	 * Returns the saml sp auth request persistence.
	 *
	 * @return the saml sp auth request persistence
	 */
	public SamlSpAuthRequestPersistence getSamlSpAuthRequestPersistence() {
		return samlSpAuthRequestPersistence;
	}

	/**
	 * Sets the saml sp auth request persistence.
	 *
	 * @param samlSpAuthRequestPersistence the saml sp auth request persistence
	 */
	public void setSamlSpAuthRequestPersistence(
		SamlSpAuthRequestPersistence samlSpAuthRequestPersistence) {
		this.samlSpAuthRequestPersistence = samlSpAuthRequestPersistence;
	}

	/**
	 * Returns the saml sp message local service.
	 *
	 * @return the saml sp message local service
	 */
	public SamlSpMessageLocalService getSamlSpMessageLocalService() {
		return samlSpMessageLocalService;
	}

	/**
	 * Sets the saml sp message local service.
	 *
	 * @param samlSpMessageLocalService the saml sp message local service
	 */
	public void setSamlSpMessageLocalService(
		SamlSpMessageLocalService samlSpMessageLocalService) {
		this.samlSpMessageLocalService = samlSpMessageLocalService;
	}

	/**
	 * Returns the saml sp message persistence.
	 *
	 * @return the saml sp message persistence
	 */
	public SamlSpMessagePersistence getSamlSpMessagePersistence() {
		return samlSpMessagePersistence;
	}

	/**
	 * Sets the saml sp message persistence.
	 *
	 * @param samlSpMessagePersistence the saml sp message persistence
	 */
	public void setSamlSpMessagePersistence(
		SamlSpMessagePersistence samlSpMessagePersistence) {
		this.samlSpMessagePersistence = samlSpMessagePersistence;
	}

	/**
	 * Returns the saml sp session local service.
	 *
	 * @return the saml sp session local service
	 */
	public SamlSpSessionLocalService getSamlSpSessionLocalService() {
		return samlSpSessionLocalService;
	}

	/**
	 * Sets the saml sp session local service.
	 *
	 * @param samlSpSessionLocalService the saml sp session local service
	 */
	public void setSamlSpSessionLocalService(
		SamlSpSessionLocalService samlSpSessionLocalService) {
		this.samlSpSessionLocalService = samlSpSessionLocalService;
	}

	/**
	 * Returns the saml sp session persistence.
	 *
	 * @return the saml sp session persistence
	 */
	public SamlSpSessionPersistence getSamlSpSessionPersistence() {
		return samlSpSessionPersistence;
	}

	/**
	 * Sets the saml sp session persistence.
	 *
	 * @param samlSpSessionPersistence the saml sp session persistence
	 */
	public void setSamlSpSessionPersistence(
		SamlSpSessionPersistence samlSpSessionPersistence) {
		this.samlSpSessionPersistence = samlSpSessionPersistence;
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
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.saml.model.SamlIdpSsoSession",
			samlIdpSsoSessionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.saml.model.SamlIdpSsoSession");
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
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return SamlIdpSsoSession.class;
	}

	protected String getModelClassName() {
		return SamlIdpSsoSession.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = samlIdpSsoSessionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SamlIdpSpSessionLocalService.class)
	protected SamlIdpSpSessionLocalService samlIdpSpSessionLocalService;
	@BeanReference(type = SamlIdpSpSessionPersistence.class)
	protected SamlIdpSpSessionPersistence samlIdpSpSessionPersistence;
	@BeanReference(type = SamlIdpSsoSessionLocalService.class)
	protected SamlIdpSsoSessionLocalService samlIdpSsoSessionLocalService;
	@BeanReference(type = SamlIdpSsoSessionPersistence.class)
	protected SamlIdpSsoSessionPersistence samlIdpSsoSessionPersistence;
	@BeanReference(type = SamlSpAuthRequestLocalService.class)
	protected SamlSpAuthRequestLocalService samlSpAuthRequestLocalService;
	@BeanReference(type = SamlSpAuthRequestPersistence.class)
	protected SamlSpAuthRequestPersistence samlSpAuthRequestPersistence;
	@BeanReference(type = SamlSpMessageLocalService.class)
	protected SamlSpMessageLocalService samlSpMessageLocalService;
	@BeanReference(type = SamlSpMessagePersistence.class)
	protected SamlSpMessagePersistence samlSpMessagePersistence;
	@BeanReference(type = SamlSpSessionLocalService.class)
	protected SamlSpSessionLocalService samlSpSessionLocalService;
	@BeanReference(type = SamlSpSessionPersistence.class)
	protected SamlSpSessionPersistence samlSpSessionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private SamlIdpSsoSessionLocalServiceClpInvoker _clpInvoker = new SamlIdpSsoSessionLocalServiceClpInvoker();
}