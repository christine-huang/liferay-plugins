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

package com.liferay.saml.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.saml.NoSuchIdpSpConnectionException;
import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.model.impl.SamlIdpSpConnectionImpl;
import com.liferay.saml.model.impl.SamlIdpSpConnectionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the saml idp sp connection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlIdpSpConnectionPersistence
 * @see SamlIdpSpConnectionUtil
 * @generated
 */
public class SamlIdpSpConnectionPersistenceImpl extends BasePersistenceImpl<SamlIdpSpConnection>
	implements SamlIdpSpConnectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SamlIdpSpConnectionUtil} to access the saml idp sp connection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SamlIdpSpConnectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			SamlIdpSpConnectionModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_SSEI = new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_SSEI",
			new String[] { Long.class.getName(), String.class.getName() },
			SamlIdpSpConnectionModelImpl.COMPANYID_COLUMN_BITMASK |
			SamlIdpSpConnectionModelImpl.SAMLSPENTITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_SSEI = new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_SSEI",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the saml idp sp connection in the entity cache if it is enabled.
	 *
	 * @param samlIdpSpConnection the saml idp sp connection
	 */
	public void cacheResult(SamlIdpSpConnection samlIdpSpConnection) {
		EntityCacheUtil.putResult(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class, samlIdpSpConnection.getPrimaryKey(),
			samlIdpSpConnection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SSEI,
			new Object[] {
				Long.valueOf(samlIdpSpConnection.getCompanyId()),
				
			samlIdpSpConnection.getSamlSpEntityId()
			}, samlIdpSpConnection);

		samlIdpSpConnection.resetOriginalValues();
	}

	/**
	 * Caches the saml idp sp connections in the entity cache if it is enabled.
	 *
	 * @param samlIdpSpConnections the saml idp sp connections
	 */
	public void cacheResult(List<SamlIdpSpConnection> samlIdpSpConnections) {
		for (SamlIdpSpConnection samlIdpSpConnection : samlIdpSpConnections) {
			if (EntityCacheUtil.getResult(
						SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
						SamlIdpSpConnectionImpl.class,
						samlIdpSpConnection.getPrimaryKey()) == null) {
				cacheResult(samlIdpSpConnection);
			}
			else {
				samlIdpSpConnection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all saml idp sp connections.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SamlIdpSpConnectionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SamlIdpSpConnectionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the saml idp sp connection.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SamlIdpSpConnection samlIdpSpConnection) {
		EntityCacheUtil.removeResult(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class, samlIdpSpConnection.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(samlIdpSpConnection);
	}

	@Override
	public void clearCache(List<SamlIdpSpConnection> samlIdpSpConnections) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SamlIdpSpConnection samlIdpSpConnection : samlIdpSpConnections) {
			EntityCacheUtil.removeResult(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
				SamlIdpSpConnectionImpl.class,
				samlIdpSpConnection.getPrimaryKey());

			clearUniqueFindersCache(samlIdpSpConnection);
		}
	}

	protected void clearUniqueFindersCache(
		SamlIdpSpConnection samlIdpSpConnection) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_SSEI,
			new Object[] {
				Long.valueOf(samlIdpSpConnection.getCompanyId()),
				
			samlIdpSpConnection.getSamlSpEntityId()
			});
	}

	/**
	 * Creates a new saml idp sp connection with the primary key. Does not add the saml idp sp connection to the database.
	 *
	 * @param samlIdpSpConnectionId the primary key for the new saml idp sp connection
	 * @return the new saml idp sp connection
	 */
	public SamlIdpSpConnection create(long samlIdpSpConnectionId) {
		SamlIdpSpConnection samlIdpSpConnection = new SamlIdpSpConnectionImpl();

		samlIdpSpConnection.setNew(true);
		samlIdpSpConnection.setPrimaryKey(samlIdpSpConnectionId);

		return samlIdpSpConnection;
	}

	/**
	 * Removes the saml idp sp connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSpConnectionId the primary key of the saml idp sp connection
	 * @return the saml idp sp connection that was removed
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection remove(long samlIdpSpConnectionId)
		throws NoSuchIdpSpConnectionException, SystemException {
		return remove(Long.valueOf(samlIdpSpConnectionId));
	}

	/**
	 * Removes the saml idp sp connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the saml idp sp connection
	 * @return the saml idp sp connection that was removed
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlIdpSpConnection remove(Serializable primaryKey)
		throws NoSuchIdpSpConnectionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SamlIdpSpConnection samlIdpSpConnection = (SamlIdpSpConnection)session.get(SamlIdpSpConnectionImpl.class,
					primaryKey);

			if (samlIdpSpConnection == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIdpSpConnectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(samlIdpSpConnection);
		}
		catch (NoSuchIdpSpConnectionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SamlIdpSpConnection removeImpl(
		SamlIdpSpConnection samlIdpSpConnection) throws SystemException {
		samlIdpSpConnection = toUnwrappedModel(samlIdpSpConnection);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, samlIdpSpConnection);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(samlIdpSpConnection);

		return samlIdpSpConnection;
	}

	@Override
	public SamlIdpSpConnection updateImpl(
		com.liferay.saml.model.SamlIdpSpConnection samlIdpSpConnection,
		boolean merge) throws SystemException {
		samlIdpSpConnection = toUnwrappedModel(samlIdpSpConnection);

		boolean isNew = samlIdpSpConnection.isNew();

		SamlIdpSpConnectionModelImpl samlIdpSpConnectionModelImpl = (SamlIdpSpConnectionModelImpl)samlIdpSpConnection;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, samlIdpSpConnection, merge);

			samlIdpSpConnection.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SamlIdpSpConnectionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((samlIdpSpConnectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(samlIdpSpConnectionModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(samlIdpSpConnectionModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpConnectionImpl.class, samlIdpSpConnection.getPrimaryKey(),
			samlIdpSpConnection);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SSEI,
				new Object[] {
					Long.valueOf(samlIdpSpConnection.getCompanyId()),
					
				samlIdpSpConnection.getSamlSpEntityId()
				}, samlIdpSpConnection);
		}
		else {
			if ((samlIdpSpConnectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_SSEI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(samlIdpSpConnectionModelImpl.getOriginalCompanyId()),
						
						samlIdpSpConnectionModelImpl.getOriginalSamlSpEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_SSEI, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_SSEI, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SSEI,
					new Object[] {
						Long.valueOf(samlIdpSpConnection.getCompanyId()),
						
					samlIdpSpConnection.getSamlSpEntityId()
					}, samlIdpSpConnection);
			}
		}

		return samlIdpSpConnection;
	}

	protected SamlIdpSpConnection toUnwrappedModel(
		SamlIdpSpConnection samlIdpSpConnection) {
		if (samlIdpSpConnection instanceof SamlIdpSpConnectionImpl) {
			return samlIdpSpConnection;
		}

		SamlIdpSpConnectionImpl samlIdpSpConnectionImpl = new SamlIdpSpConnectionImpl();

		samlIdpSpConnectionImpl.setNew(samlIdpSpConnection.isNew());
		samlIdpSpConnectionImpl.setPrimaryKey(samlIdpSpConnection.getPrimaryKey());

		samlIdpSpConnectionImpl.setSamlIdpSpConnectionId(samlIdpSpConnection.getSamlIdpSpConnectionId());
		samlIdpSpConnectionImpl.setCompanyId(samlIdpSpConnection.getCompanyId());
		samlIdpSpConnectionImpl.setUserId(samlIdpSpConnection.getUserId());
		samlIdpSpConnectionImpl.setUserName(samlIdpSpConnection.getUserName());
		samlIdpSpConnectionImpl.setCreateDate(samlIdpSpConnection.getCreateDate());
		samlIdpSpConnectionImpl.setModifiedDate(samlIdpSpConnection.getModifiedDate());
		samlIdpSpConnectionImpl.setSamlSpEntityId(samlIdpSpConnection.getSamlSpEntityId());
		samlIdpSpConnectionImpl.setAttributeNames(samlIdpSpConnection.getAttributeNames());
		samlIdpSpConnectionImpl.setAttributesEnabled(samlIdpSpConnection.isAttributesEnabled());
		samlIdpSpConnectionImpl.setAttributesNamespaceEnabled(samlIdpSpConnection.isAttributesNamespaceEnabled());
		samlIdpSpConnectionImpl.setAssertionLifetime(samlIdpSpConnection.getAssertionLifetime());
		samlIdpSpConnectionImpl.setEnabled(samlIdpSpConnection.isEnabled());
		samlIdpSpConnectionImpl.setMetadataUrl(samlIdpSpConnection.getMetadataUrl());
		samlIdpSpConnectionImpl.setMetadataXml(samlIdpSpConnection.getMetadataXml());
		samlIdpSpConnectionImpl.setMetadataUpdatedDate(samlIdpSpConnection.getMetadataUpdatedDate());
		samlIdpSpConnectionImpl.setName(samlIdpSpConnection.getName());
		samlIdpSpConnectionImpl.setNameIdAttribute(samlIdpSpConnection.getNameIdAttribute());
		samlIdpSpConnectionImpl.setNameIdFormat(samlIdpSpConnection.getNameIdFormat());

		return samlIdpSpConnectionImpl;
	}

	/**
	 * Returns the saml idp sp connection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the saml idp sp connection
	 * @return the saml idp sp connection
	 * @throws com.liferay.portal.NoSuchModelException if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlIdpSpConnection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the saml idp sp connection with the primary key or throws a {@link com.liferay.saml.NoSuchIdpSpConnectionException} if it could not be found.
	 *
	 * @param samlIdpSpConnectionId the primary key of the saml idp sp connection
	 * @return the saml idp sp connection
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection findByPrimaryKey(long samlIdpSpConnectionId)
		throws NoSuchIdpSpConnectionException, SystemException {
		SamlIdpSpConnection samlIdpSpConnection = fetchByPrimaryKey(samlIdpSpConnectionId);

		if (samlIdpSpConnection == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					samlIdpSpConnectionId);
			}

			throw new NoSuchIdpSpConnectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				samlIdpSpConnectionId);
		}

		return samlIdpSpConnection;
	}

	/**
	 * Returns the saml idp sp connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the saml idp sp connection
	 * @return the saml idp sp connection, or <code>null</code> if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlIdpSpConnection fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the saml idp sp connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param samlIdpSpConnectionId the primary key of the saml idp sp connection
	 * @return the saml idp sp connection, or <code>null</code> if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection fetchByPrimaryKey(long samlIdpSpConnectionId)
		throws SystemException {
		SamlIdpSpConnection samlIdpSpConnection = (SamlIdpSpConnection)EntityCacheUtil.getResult(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
				SamlIdpSpConnectionImpl.class, samlIdpSpConnectionId);

		if (samlIdpSpConnection == _nullSamlIdpSpConnection) {
			return null;
		}

		if (samlIdpSpConnection == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				samlIdpSpConnection = (SamlIdpSpConnection)session.get(SamlIdpSpConnectionImpl.class,
						Long.valueOf(samlIdpSpConnectionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (samlIdpSpConnection != null) {
					cacheResult(samlIdpSpConnection);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SamlIdpSpConnectionModelImpl.ENTITY_CACHE_ENABLED,
						SamlIdpSpConnectionImpl.class, samlIdpSpConnectionId,
						_nullSamlIdpSpConnection);
				}

				closeSession(session);
			}
		}

		return samlIdpSpConnection;
	}

	/**
	 * Returns all the saml idp sp connections where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpConnection> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the saml idp sp connections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of saml idp sp connections
	 * @param end the upper bound of the range of saml idp sp connections (not inclusive)
	 * @return the range of matching saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpConnection> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the saml idp sp connections where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of saml idp sp connections
	 * @param end the upper bound of the range of saml idp sp connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpConnection> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<SamlIdpSpConnection> list = (List<SamlIdpSpConnection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SamlIdpSpConnection samlIdpSpConnection : list) {
				if ((companyId != samlIdpSpConnection.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SAMLIDPSPCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<SamlIdpSpConnection>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first saml idp sp connection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saml idp sp connection
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchIdpSpConnectionException, SystemException {
		SamlIdpSpConnection samlIdpSpConnection = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (samlIdpSpConnection != null) {
			return samlIdpSpConnection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIdpSpConnectionException(msg.toString());
	}

	/**
	 * Returns the first saml idp sp connection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saml idp sp connection, or <code>null</code> if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SamlIdpSpConnection> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last saml idp sp connection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saml idp sp connection
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchIdpSpConnectionException, SystemException {
		SamlIdpSpConnection samlIdpSpConnection = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (samlIdpSpConnection != null) {
			return samlIdpSpConnection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIdpSpConnectionException(msg.toString());
	}

	/**
	 * Returns the last saml idp sp connection in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saml idp sp connection, or <code>null</code> if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<SamlIdpSpConnection> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the saml idp sp connections before and after the current saml idp sp connection in the ordered set where companyId = &#63;.
	 *
	 * @param samlIdpSpConnectionId the primary key of the current saml idp sp connection
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saml idp sp connection
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a saml idp sp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection[] findByCompanyId_PrevAndNext(
		long samlIdpSpConnectionId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchIdpSpConnectionException, SystemException {
		SamlIdpSpConnection samlIdpSpConnection = findByPrimaryKey(samlIdpSpConnectionId);

		Session session = null;

		try {
			session = openSession();

			SamlIdpSpConnection[] array = new SamlIdpSpConnectionImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, samlIdpSpConnection,
					companyId, orderByComparator, true);

			array[1] = samlIdpSpConnection;

			array[2] = getByCompanyId_PrevAndNext(session, samlIdpSpConnection,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SamlIdpSpConnection getByCompanyId_PrevAndNext(Session session,
		SamlIdpSpConnection samlIdpSpConnection, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMLIDPSPCONNECTION_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(samlIdpSpConnection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SamlIdpSpConnection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the saml idp sp connection where companyId = &#63; and samlSpEntityId = &#63; or throws a {@link com.liferay.saml.NoSuchIdpSpConnectionException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the matching saml idp sp connection
	 * @throws com.liferay.saml.NoSuchIdpSpConnectionException if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection findByC_SSEI(long companyId,
		String samlSpEntityId)
		throws NoSuchIdpSpConnectionException, SystemException {
		SamlIdpSpConnection samlIdpSpConnection = fetchByC_SSEI(companyId,
				samlSpEntityId);

		if (samlIdpSpConnection == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", samlSpEntityId=");
			msg.append(samlSpEntityId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIdpSpConnectionException(msg.toString());
		}

		return samlIdpSpConnection;
	}

	/**
	 * Returns the saml idp sp connection where companyId = &#63; and samlSpEntityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the matching saml idp sp connection, or <code>null</code> if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection fetchByC_SSEI(long companyId,
		String samlSpEntityId) throws SystemException {
		return fetchByC_SSEI(companyId, samlSpEntityId, true);
	}

	/**
	 * Returns the saml idp sp connection where companyId = &#63; and samlSpEntityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching saml idp sp connection, or <code>null</code> if a matching saml idp sp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection fetchByC_SSEI(long companyId,
		String samlSpEntityId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, samlSpEntityId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_SSEI,
					finderArgs, this);
		}

		if (result instanceof SamlIdpSpConnection) {
			SamlIdpSpConnection samlIdpSpConnection = (SamlIdpSpConnection)result;

			if ((companyId != samlIdpSpConnection.getCompanyId()) ||
					!Validator.equals(samlSpEntityId,
						samlIdpSpConnection.getSamlSpEntityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SAMLIDPSPCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_C_SSEI_COMPANYID_2);

			if (samlSpEntityId == null) {
				query.append(_FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_1);
			}
			else {
				if (samlSpEntityId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (samlSpEntityId != null) {
					qPos.add(samlSpEntityId);
				}

				List<SamlIdpSpConnection> list = q.list();

				result = list;

				SamlIdpSpConnection samlIdpSpConnection = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SSEI,
						finderArgs, list);
				}
				else {
					samlIdpSpConnection = list.get(0);

					cacheResult(samlIdpSpConnection);

					if ((samlIdpSpConnection.getCompanyId() != companyId) ||
							(samlIdpSpConnection.getSamlSpEntityId() == null) ||
							!samlIdpSpConnection.getSamlSpEntityId()
													.equals(samlSpEntityId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_SSEI,
							finderArgs, samlIdpSpConnection);
					}
				}

				return samlIdpSpConnection;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_SSEI,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (SamlIdpSpConnection)result;
			}
		}
	}

	/**
	 * Returns all the saml idp sp connections.
	 *
	 * @return the saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpConnection> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saml idp sp connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml idp sp connections
	 * @param end the upper bound of the range of saml idp sp connections (not inclusive)
	 * @return the range of saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpConnection> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the saml idp sp connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml idp sp connections
	 * @param end the upper bound of the range of saml idp sp connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpConnection> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SamlIdpSpConnection> list = (List<SamlIdpSpConnection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMLIDPSPCONNECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMLIDPSPCONNECTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SamlIdpSpConnection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SamlIdpSpConnection>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the saml idp sp connections where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (SamlIdpSpConnection samlIdpSpConnection : findByCompanyId(
				companyId)) {
			remove(samlIdpSpConnection);
		}
	}

	/**
	 * Removes the saml idp sp connection where companyId = &#63; and samlSpEntityId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the saml idp sp connection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpConnection removeByC_SSEI(long companyId,
		String samlSpEntityId)
		throws NoSuchIdpSpConnectionException, SystemException {
		SamlIdpSpConnection samlIdpSpConnection = findByC_SSEI(companyId,
				samlSpEntityId);

		return remove(samlIdpSpConnection);
	}

	/**
	 * Removes all the saml idp sp connections from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SamlIdpSpConnection samlIdpSpConnection : findAll()) {
			remove(samlIdpSpConnection);
		}
	}

	/**
	 * Returns the number of saml idp sp connections where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMLIDPSPCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of saml idp sp connections where companyId = &#63; and samlSpEntityId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the number of matching saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_SSEI(long companyId, String samlSpEntityId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, samlSpEntityId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_SSEI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMLIDPSPCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_C_SSEI_COMPANYID_2);

			if (samlSpEntityId == null) {
				query.append(_FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_1);
			}
			else {
				if (samlSpEntityId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (samlSpEntityId != null) {
					qPos.add(samlSpEntityId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_SSEI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of saml idp sp connections.
	 *
	 * @return the number of saml idp sp connections
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SAMLIDPSPCONNECTION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the saml idp sp connection persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.saml.model.SamlIdpSpConnection")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SamlIdpSpConnection>> listenersList = new ArrayList<ModelListener<SamlIdpSpConnection>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SamlIdpSpConnection>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SamlIdpSpConnectionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = SamlIdpSpConnectionPersistence.class)
	protected SamlIdpSpConnectionPersistence samlIdpSpConnectionPersistence;
	@BeanReference(type = SamlIdpSpSessionPersistence.class)
	protected SamlIdpSpSessionPersistence samlIdpSpSessionPersistence;
	@BeanReference(type = SamlIdpSsoSessionPersistence.class)
	protected SamlIdpSsoSessionPersistence samlIdpSsoSessionPersistence;
	@BeanReference(type = SamlSpAuthRequestPersistence.class)
	protected SamlSpAuthRequestPersistence samlSpAuthRequestPersistence;
	@BeanReference(type = SamlSpIdpConnectionPersistence.class)
	protected SamlSpIdpConnectionPersistence samlSpIdpConnectionPersistence;
	@BeanReference(type = SamlSpMessagePersistence.class)
	protected SamlSpMessagePersistence samlSpMessagePersistence;
	@BeanReference(type = SamlSpSessionPersistence.class)
	protected SamlSpSessionPersistence samlSpSessionPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SAMLIDPSPCONNECTION = "SELECT samlIdpSpConnection FROM SamlIdpSpConnection samlIdpSpConnection";
	private static final String _SQL_SELECT_SAMLIDPSPCONNECTION_WHERE = "SELECT samlIdpSpConnection FROM SamlIdpSpConnection samlIdpSpConnection WHERE ";
	private static final String _SQL_COUNT_SAMLIDPSPCONNECTION = "SELECT COUNT(samlIdpSpConnection) FROM SamlIdpSpConnection samlIdpSpConnection";
	private static final String _SQL_COUNT_SAMLIDPSPCONNECTION_WHERE = "SELECT COUNT(samlIdpSpConnection) FROM SamlIdpSpConnection samlIdpSpConnection WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "samlIdpSpConnection.companyId = ?";
	private static final String _FINDER_COLUMN_C_SSEI_COMPANYID_2 = "samlIdpSpConnection.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_1 = "samlIdpSpConnection.samlSpEntityId IS NULL";
	private static final String _FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_2 = "samlIdpSpConnection.samlSpEntityId = ?";
	private static final String _FINDER_COLUMN_C_SSEI_SAMLSPENTITYID_3 = "(samlIdpSpConnection.samlSpEntityId IS NULL OR samlIdpSpConnection.samlSpEntityId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "samlIdpSpConnection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SamlIdpSpConnection exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SamlIdpSpConnection exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SamlIdpSpConnectionPersistenceImpl.class);
	private static SamlIdpSpConnection _nullSamlIdpSpConnection = new SamlIdpSpConnectionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SamlIdpSpConnection> toCacheModel() {
				return _nullSamlIdpSpConnectionCacheModel;
			}
		};

	private static CacheModel<SamlIdpSpConnection> _nullSamlIdpSpConnectionCacheModel =
		new CacheModel<SamlIdpSpConnection>() {
			public SamlIdpSpConnection toEntityModel() {
				return _nullSamlIdpSpConnection;
			}
		};
}