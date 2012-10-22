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

package com.liferay.portal.workflow.kaleo.forms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess;

import java.util.List;

/**
 * The persistence utility for the kaleo process service. This utility wraps {@link KaleoProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcellus Tavares
 * @see KaleoProcessPersistence
 * @see KaleoProcessPersistenceImpl
 * @generated
 */
public class KaleoProcessUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(KaleoProcess kaleoProcess) {
		getPersistence().clearCache(kaleoProcess);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<KaleoProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KaleoProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KaleoProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static KaleoProcess update(KaleoProcess kaleoProcess)
		throws SystemException {
		return getPersistence().update(kaleoProcess);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static KaleoProcess update(KaleoProcess kaleoProcess,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(kaleoProcess, serviceContext);
	}

	/**
	* Caches the kaleo process in the entity cache if it is enabled.
	*
	* @param kaleoProcess the kaleo process
	*/
	public static void cacheResult(
		com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess kaleoProcess) {
		getPersistence().cacheResult(kaleoProcess);
	}

	/**
	* Caches the kaleo processes in the entity cache if it is enabled.
	*
	* @param kaleoProcesses the kaleo processes
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> kaleoProcesses) {
		getPersistence().cacheResult(kaleoProcesses);
	}

	/**
	* Creates a new kaleo process with the primary key. Does not add the kaleo process to the database.
	*
	* @param kaleoProcessId the primary key for the new kaleo process
	* @return the new kaleo process
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess create(
		long kaleoProcessId) {
		return getPersistence().create(kaleoProcessId);
	}

	/**
	* Removes the kaleo process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kaleoProcessId the primary key of the kaleo process
	* @return the kaleo process that was removed
	* @throws com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException if a kaleo process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess remove(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException {
		return getPersistence().remove(kaleoProcessId);
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess updateImpl(
		com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess kaleoProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(kaleoProcess);
	}

	/**
	* Returns the kaleo process with the primary key or throws a {@link com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException} if it could not be found.
	*
	* @param kaleoProcessId the primary key of the kaleo process
	* @return the kaleo process
	* @throws com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException if a kaleo process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess findByPrimaryKey(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException {
		return getPersistence().findByPrimaryKey(kaleoProcessId);
	}

	/**
	* Returns the kaleo process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kaleoProcessId the primary key of the kaleo process
	* @return the kaleo process, or <code>null</code> if a kaleo process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess fetchByPrimaryKey(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(kaleoProcessId);
	}

	/**
	* Returns all the kaleo processes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the kaleo processes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kaleo processes
	* @param end the upper bound of the range of kaleo processes (not inclusive)
	* @return the range of matching kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the kaleo processes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kaleo processes
	* @param end the upper bound of the range of kaleo processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first kaleo process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kaleo process
	* @throws com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException if a matching kaleo process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first kaleo process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kaleo process, or <code>null</code> if a matching kaleo process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last kaleo process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kaleo process
	* @throws com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException if a matching kaleo process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last kaleo process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kaleo process, or <code>null</code> if a matching kaleo process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the kaleo processes before and after the current kaleo process in the ordered set where groupId = &#63;.
	*
	* @param kaleoProcessId the primary key of the current kaleo process
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kaleo process
	* @throws com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException if a kaleo process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess[] findByGroupId_PrevAndNext(
		long kaleoProcessId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(kaleoProcessId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the kaleo processes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching kaleo processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the kaleo processes that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kaleo processes
	* @param end the upper bound of the range of kaleo processes (not inclusive)
	* @return the range of matching kaleo processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the kaleo processes that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kaleo processes
	* @param end the upper bound of the range of kaleo processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kaleo processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the kaleo processes before and after the current kaleo process in the ordered set of kaleo processes that the user has permission to view where groupId = &#63;.
	*
	* @param kaleoProcessId the primary key of the current kaleo process
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kaleo process
	* @throws com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException if a kaleo process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess[] filterFindByGroupId_PrevAndNext(
		long kaleoProcessId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.forms.NoSuchKaleoProcessException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(kaleoProcessId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the kaleo processes.
	*
	* @return the kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the kaleo processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of kaleo processes
	* @param end the upper bound of the range of kaleo processes (not inclusive)
	* @return the range of kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the kaleo processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of kaleo processes
	* @param end the upper bound of the range of kaleo processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the kaleo processes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the kaleo processes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of kaleo processes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of kaleo processes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching kaleo processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of kaleo processes.
	*
	* @return the number of kaleo processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KaleoProcessPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KaleoProcessPersistence)PortletBeanLocatorUtil.locate(com.liferay.portal.workflow.kaleo.forms.service.ClpSerializer.getServletContextName(),
					KaleoProcessPersistence.class.getName());

			ReferenceRegistry.registerReference(KaleoProcessUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(KaleoProcessPersistence persistence) {
	}

	private static KaleoProcessPersistence _persistence;
}