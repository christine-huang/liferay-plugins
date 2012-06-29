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

import com.liferay.saml.NoSuchIdpSpSessionException;
import com.liferay.saml.model.SamlIdpSpSession;
import com.liferay.saml.model.impl.SamlIdpSpSessionImpl;
import com.liferay.saml.model.impl.SamlIdpSpSessionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the saml idp sp session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlIdpSpSessionPersistence
 * @see SamlIdpSpSessionUtil
 * @generated
 */
public class SamlIdpSpSessionPersistenceImpl extends BasePersistenceImpl<SamlIdpSpSession>
	implements SamlIdpSpSessionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SamlIdpSpSessionUtil} to access the saml idp sp session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SamlIdpSpSessionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID =
		new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySamlIdpSsoSessionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID =
		new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySamlIdpSsoSessionId", new String[] { Long.class.getName() },
			SamlIdpSpSessionModelImpl.SAMLIDPSSOSESSIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SAMLIDPSSOSESSIONID = new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySamlIdpSsoSessionId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_SISSI_SSEI = new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySISSI_SSEI",
			new String[] { Long.class.getName(), String.class.getName() },
			SamlIdpSpSessionModelImpl.SAMLIDPSSOSESSIONID_COLUMN_BITMASK |
			SamlIdpSpSessionModelImpl.SAMLSPENTITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SISSI_SSEI = new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySISSI_SSEI",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the saml idp sp session in the entity cache if it is enabled.
	 *
	 * @param samlIdpSpSession the saml idp sp session
	 */
	public void cacheResult(SamlIdpSpSession samlIdpSpSession) {
		EntityCacheUtil.putResult(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class, samlIdpSpSession.getPrimaryKey(),
			samlIdpSpSession);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
			new Object[] {
				Long.valueOf(samlIdpSpSession.getSamlIdpSsoSessionId()),
				
			samlIdpSpSession.getSamlSpEntityId()
			}, samlIdpSpSession);

		samlIdpSpSession.resetOriginalValues();
	}

	/**
	 * Caches the saml idp sp sessions in the entity cache if it is enabled.
	 *
	 * @param samlIdpSpSessions the saml idp sp sessions
	 */
	public void cacheResult(List<SamlIdpSpSession> samlIdpSpSessions) {
		for (SamlIdpSpSession samlIdpSpSession : samlIdpSpSessions) {
			if (EntityCacheUtil.getResult(
						SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
						SamlIdpSpSessionImpl.class,
						samlIdpSpSession.getPrimaryKey()) == null) {
				cacheResult(samlIdpSpSession);
			}
			else {
				samlIdpSpSession.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all saml idp sp sessions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SamlIdpSpSessionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SamlIdpSpSessionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the saml idp sp session.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SamlIdpSpSession samlIdpSpSession) {
		EntityCacheUtil.removeResult(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class, samlIdpSpSession.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(samlIdpSpSession);
	}

	@Override
	public void clearCache(List<SamlIdpSpSession> samlIdpSpSessions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SamlIdpSpSession samlIdpSpSession : samlIdpSpSessions) {
			EntityCacheUtil.removeResult(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
				SamlIdpSpSessionImpl.class, samlIdpSpSession.getPrimaryKey());

			clearUniqueFindersCache(samlIdpSpSession);
		}
	}

	protected void clearUniqueFindersCache(SamlIdpSpSession samlIdpSpSession) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
			new Object[] {
				Long.valueOf(samlIdpSpSession.getSamlIdpSsoSessionId()),
				
			samlIdpSpSession.getSamlSpEntityId()
			});
	}

	/**
	 * Creates a new saml idp sp session with the primary key. Does not add the saml idp sp session to the database.
	 *
	 * @param samlIdpSpSessionId the primary key for the new saml idp sp session
	 * @return the new saml idp sp session
	 */
	public SamlIdpSpSession create(long samlIdpSpSessionId) {
		SamlIdpSpSession samlIdpSpSession = new SamlIdpSpSessionImpl();

		samlIdpSpSession.setNew(true);
		samlIdpSpSession.setPrimaryKey(samlIdpSpSessionId);

		return samlIdpSpSession;
	}

	/**
	 * Removes the saml idp sp session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samlIdpSpSessionId the primary key of the saml idp sp session
	 * @return the saml idp sp session that was removed
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession remove(long samlIdpSpSessionId)
		throws NoSuchIdpSpSessionException, SystemException {
		return remove(Long.valueOf(samlIdpSpSessionId));
	}

	/**
	 * Removes the saml idp sp session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the saml idp sp session
	 * @return the saml idp sp session that was removed
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlIdpSpSession remove(Serializable primaryKey)
		throws NoSuchIdpSpSessionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SamlIdpSpSession samlIdpSpSession = (SamlIdpSpSession)session.get(SamlIdpSpSessionImpl.class,
					primaryKey);

			if (samlIdpSpSession == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIdpSpSessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(samlIdpSpSession);
		}
		catch (NoSuchIdpSpSessionException nsee) {
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
	protected SamlIdpSpSession removeImpl(SamlIdpSpSession samlIdpSpSession)
		throws SystemException {
		samlIdpSpSession = toUnwrappedModel(samlIdpSpSession);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, samlIdpSpSession);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(samlIdpSpSession);

		return samlIdpSpSession;
	}

	@Override
	public SamlIdpSpSession updateImpl(
		com.liferay.saml.model.SamlIdpSpSession samlIdpSpSession, boolean merge)
		throws SystemException {
		samlIdpSpSession = toUnwrappedModel(samlIdpSpSession);

		boolean isNew = samlIdpSpSession.isNew();

		SamlIdpSpSessionModelImpl samlIdpSpSessionModelImpl = (SamlIdpSpSessionModelImpl)samlIdpSpSession;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, samlIdpSpSession, merge);

			samlIdpSpSession.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SamlIdpSpSessionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((samlIdpSpSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(samlIdpSpSessionModelImpl.getOriginalSamlIdpSsoSessionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMLIDPSSOSESSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID,
					args);

				args = new Object[] {
						Long.valueOf(samlIdpSpSessionModelImpl.getSamlIdpSsoSessionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMLIDPSSOSESSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
			SamlIdpSpSessionImpl.class, samlIdpSpSession.getPrimaryKey(),
			samlIdpSpSession);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
				new Object[] {
					Long.valueOf(samlIdpSpSession.getSamlIdpSsoSessionId()),
					
				samlIdpSpSession.getSamlSpEntityId()
				}, samlIdpSpSession);
		}
		else {
			if ((samlIdpSpSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SISSI_SSEI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(samlIdpSpSessionModelImpl.getOriginalSamlIdpSsoSessionId()),
						
						samlIdpSpSessionModelImpl.getOriginalSamlSpEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SISSI_SSEI,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
					new Object[] {
						Long.valueOf(samlIdpSpSession.getSamlIdpSsoSessionId()),
						
					samlIdpSpSession.getSamlSpEntityId()
					}, samlIdpSpSession);
			}
		}

		return samlIdpSpSession;
	}

	protected SamlIdpSpSession toUnwrappedModel(
		SamlIdpSpSession samlIdpSpSession) {
		if (samlIdpSpSession instanceof SamlIdpSpSessionImpl) {
			return samlIdpSpSession;
		}

		SamlIdpSpSessionImpl samlIdpSpSessionImpl = new SamlIdpSpSessionImpl();

		samlIdpSpSessionImpl.setNew(samlIdpSpSession.isNew());
		samlIdpSpSessionImpl.setPrimaryKey(samlIdpSpSession.getPrimaryKey());

		samlIdpSpSessionImpl.setSamlIdpSpSessionId(samlIdpSpSession.getSamlIdpSpSessionId());
		samlIdpSpSessionImpl.setCompanyId(samlIdpSpSession.getCompanyId());
		samlIdpSpSessionImpl.setUserId(samlIdpSpSession.getUserId());
		samlIdpSpSessionImpl.setUserName(samlIdpSpSession.getUserName());
		samlIdpSpSessionImpl.setCreateDate(samlIdpSpSession.getCreateDate());
		samlIdpSpSessionImpl.setModifiedDate(samlIdpSpSession.getModifiedDate());
		samlIdpSpSessionImpl.setSamlIdpSsoSessionId(samlIdpSpSession.getSamlIdpSsoSessionId());
		samlIdpSpSessionImpl.setSamlSpEntityId(samlIdpSpSession.getSamlSpEntityId());
		samlIdpSpSessionImpl.setNameIdFormat(samlIdpSpSession.getNameIdFormat());
		samlIdpSpSessionImpl.setNameIdValue(samlIdpSpSession.getNameIdValue());

		return samlIdpSpSessionImpl;
	}

	/**
	 * Returns the saml idp sp session with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the saml idp sp session
	 * @return the saml idp sp session
	 * @throws com.liferay.portal.NoSuchModelException if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlIdpSpSession findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the saml idp sp session with the primary key or throws a {@link com.liferay.saml.NoSuchIdpSpSessionException} if it could not be found.
	 *
	 * @param samlIdpSpSessionId the primary key of the saml idp sp session
	 * @return the saml idp sp session
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession findByPrimaryKey(long samlIdpSpSessionId)
		throws NoSuchIdpSpSessionException, SystemException {
		SamlIdpSpSession samlIdpSpSession = fetchByPrimaryKey(samlIdpSpSessionId);

		if (samlIdpSpSession == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					samlIdpSpSessionId);
			}

			throw new NoSuchIdpSpSessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				samlIdpSpSessionId);
		}

		return samlIdpSpSession;
	}

	/**
	 * Returns the saml idp sp session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the saml idp sp session
	 * @return the saml idp sp session, or <code>null</code> if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlIdpSpSession fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the saml idp sp session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param samlIdpSpSessionId the primary key of the saml idp sp session
	 * @return the saml idp sp session, or <code>null</code> if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession fetchByPrimaryKey(long samlIdpSpSessionId)
		throws SystemException {
		SamlIdpSpSession samlIdpSpSession = (SamlIdpSpSession)EntityCacheUtil.getResult(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
				SamlIdpSpSessionImpl.class, samlIdpSpSessionId);

		if (samlIdpSpSession == _nullSamlIdpSpSession) {
			return null;
		}

		if (samlIdpSpSession == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				samlIdpSpSession = (SamlIdpSpSession)session.get(SamlIdpSpSessionImpl.class,
						Long.valueOf(samlIdpSpSessionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (samlIdpSpSession != null) {
					cacheResult(samlIdpSpSession);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SamlIdpSpSessionModelImpl.ENTITY_CACHE_ENABLED,
						SamlIdpSpSessionImpl.class, samlIdpSpSessionId,
						_nullSamlIdpSpSession);
				}

				closeSession(session);
			}
		}

		return samlIdpSpSession;
	}

	/**
	 * Returns all the saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @return the matching saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpSession> findBySamlIdpSsoSessionId(
		long samlIdpSsoSessionId) throws SystemException {
		return findBySamlIdpSsoSessionId(samlIdpSsoSessionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param start the lower bound of the range of saml idp sp sessions
	 * @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	 * @return the range of matching saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpSession> findBySamlIdpSsoSessionId(
		long samlIdpSsoSessionId, int start, int end) throws SystemException {
		return findBySamlIdpSsoSessionId(samlIdpSsoSessionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param start the lower bound of the range of saml idp sp sessions
	 * @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpSession> findBySamlIdpSsoSessionId(
		long samlIdpSsoSessionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID;
			finderArgs = new Object[] { samlIdpSsoSessionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMLIDPSSOSESSIONID;
			finderArgs = new Object[] {
					samlIdpSsoSessionId,
					
					start, end, orderByComparator
				};
		}

		List<SamlIdpSpSession> list = (List<SamlIdpSpSession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SamlIdpSpSession samlIdpSpSession : list) {
				if ((samlIdpSsoSessionId != samlIdpSpSession.getSamlIdpSsoSessionId())) {
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

			query.append(_SQL_SELECT_SAMLIDPSPSESSION_WHERE);

			query.append(_FINDER_COLUMN_SAMLIDPSSOSESSIONID_SAMLIDPSSOSESSIONID_2);

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

				qPos.add(samlIdpSsoSessionId);

				list = (List<SamlIdpSpSession>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saml idp sp session
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a matching saml idp sp session could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession findBySamlIdpSsoSessionId_First(
		long samlIdpSsoSessionId, OrderByComparator orderByComparator)
		throws NoSuchIdpSpSessionException, SystemException {
		List<SamlIdpSpSession> list = findBySamlIdpSsoSessionId(samlIdpSsoSessionId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("samlIdpSsoSessionId=");
			msg.append(samlIdpSsoSessionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIdpSpSessionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saml idp sp session
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a matching saml idp sp session could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession findBySamlIdpSsoSessionId_Last(
		long samlIdpSsoSessionId, OrderByComparator orderByComparator)
		throws NoSuchIdpSpSessionException, SystemException {
		int count = countBySamlIdpSsoSessionId(samlIdpSsoSessionId);

		List<SamlIdpSpSession> list = findBySamlIdpSsoSessionId(samlIdpSsoSessionId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("samlIdpSsoSessionId=");
			msg.append(samlIdpSsoSessionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIdpSpSessionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the saml idp sp sessions before and after the current saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param samlIdpSpSessionId the primary key of the current saml idp sp session
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saml idp sp session
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession[] findBySamlIdpSsoSessionId_PrevAndNext(
		long samlIdpSpSessionId, long samlIdpSsoSessionId,
		OrderByComparator orderByComparator)
		throws NoSuchIdpSpSessionException, SystemException {
		SamlIdpSpSession samlIdpSpSession = findByPrimaryKey(samlIdpSpSessionId);

		Session session = null;

		try {
			session = openSession();

			SamlIdpSpSession[] array = new SamlIdpSpSessionImpl[3];

			array[0] = getBySamlIdpSsoSessionId_PrevAndNext(session,
					samlIdpSpSession, samlIdpSsoSessionId, orderByComparator,
					true);

			array[1] = samlIdpSpSession;

			array[2] = getBySamlIdpSsoSessionId_PrevAndNext(session,
					samlIdpSpSession, samlIdpSsoSessionId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SamlIdpSpSession getBySamlIdpSsoSessionId_PrevAndNext(
		Session session, SamlIdpSpSession samlIdpSpSession,
		long samlIdpSsoSessionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMLIDPSPSESSION_WHERE);

		query.append(_FINDER_COLUMN_SAMLIDPSSOSESSIONID_SAMLIDPSSOSESSIONID_2);

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

		qPos.add(samlIdpSsoSessionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(samlIdpSpSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SamlIdpSpSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; or throws a {@link com.liferay.saml.NoSuchIdpSpSessionException} if it could not be found.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the matching saml idp sp session
	 * @throws com.liferay.saml.NoSuchIdpSpSessionException if a matching saml idp sp session could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession findBySISSI_SSEI(long samlIdpSsoSessionId,
		String samlSpEntityId)
		throws NoSuchIdpSpSessionException, SystemException {
		SamlIdpSpSession samlIdpSpSession = fetchBySISSI_SSEI(samlIdpSsoSessionId,
				samlSpEntityId);

		if (samlIdpSpSession == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("samlIdpSsoSessionId=");
			msg.append(samlIdpSsoSessionId);

			msg.append(", samlSpEntityId=");
			msg.append(samlSpEntityId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIdpSpSessionException(msg.toString());
		}

		return samlIdpSpSession;
	}

	/**
	 * Returns the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the matching saml idp sp session, or <code>null</code> if a matching saml idp sp session could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession fetchBySISSI_SSEI(long samlIdpSsoSessionId,
		String samlSpEntityId) throws SystemException {
		return fetchBySISSI_SSEI(samlIdpSsoSessionId, samlSpEntityId, true);
	}

	/**
	 * Returns the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching saml idp sp session, or <code>null</code> if a matching saml idp sp session could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession fetchBySISSI_SSEI(long samlIdpSsoSessionId,
		String samlSpEntityId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { samlIdpSsoSessionId, samlSpEntityId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
					finderArgs, this);
		}

		if (result instanceof SamlIdpSpSession) {
			SamlIdpSpSession samlIdpSpSession = (SamlIdpSpSession)result;

			if ((samlIdpSsoSessionId != samlIdpSpSession.getSamlIdpSsoSessionId()) ||
					!Validator.equals(samlSpEntityId,
						samlIdpSpSession.getSamlSpEntityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SAMLIDPSPSESSION_WHERE);

			query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLIDPSSOSESSIONID_2);

			if (samlSpEntityId == null) {
				query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_1);
			}
			else {
				if (samlSpEntityId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_3);
				}
				else {
					query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(samlIdpSsoSessionId);

				if (samlSpEntityId != null) {
					qPos.add(samlSpEntityId);
				}

				List<SamlIdpSpSession> list = q.list();

				result = list;

				SamlIdpSpSession samlIdpSpSession = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
						finderArgs, list);
				}
				else {
					samlIdpSpSession = list.get(0);

					cacheResult(samlIdpSpSession);

					if ((samlIdpSpSession.getSamlIdpSsoSessionId() != samlIdpSsoSessionId) ||
							(samlIdpSpSession.getSamlSpEntityId() == null) ||
							!samlIdpSpSession.getSamlSpEntityId()
												 .equals(samlSpEntityId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
							finderArgs, samlIdpSpSession);
					}
				}

				return samlIdpSpSession;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SISSI_SSEI,
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
				return (SamlIdpSpSession)result;
			}
		}
	}

	/**
	 * Returns all the saml idp sp sessions.
	 *
	 * @return the saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpSession> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saml idp sp sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml idp sp sessions
	 * @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	 * @return the range of saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpSession> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the saml idp sp sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml idp sp sessions
	 * @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SamlIdpSpSession> findAll(int start, int end,
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

		List<SamlIdpSpSession> list = (List<SamlIdpSpSession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMLIDPSPSESSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMLIDPSPSESSION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SamlIdpSpSession>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SamlIdpSpSession>)QueryUtil.list(q,
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
	 * Removes all the saml idp sp sessions where samlIdpSsoSessionId = &#63; from the database.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySamlIdpSsoSessionId(long samlIdpSsoSessionId)
		throws SystemException {
		for (SamlIdpSpSession samlIdpSpSession : findBySamlIdpSsoSessionId(
				samlIdpSsoSessionId)) {
			remove(samlIdpSpSession);
		}
	}

	/**
	 * Removes the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; from the database.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the saml idp sp session that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public SamlIdpSpSession removeBySISSI_SSEI(long samlIdpSsoSessionId,
		String samlSpEntityId)
		throws NoSuchIdpSpSessionException, SystemException {
		SamlIdpSpSession samlIdpSpSession = findBySISSI_SSEI(samlIdpSsoSessionId,
				samlSpEntityId);

		return remove(samlIdpSpSession);
	}

	/**
	 * Removes all the saml idp sp sessions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SamlIdpSpSession samlIdpSpSession : findAll()) {
			remove(samlIdpSpSession);
		}
	}

	/**
	 * Returns the number of saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @return the number of matching saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySamlIdpSsoSessionId(long samlIdpSsoSessionId)
		throws SystemException {
		Object[] finderArgs = new Object[] { samlIdpSsoSessionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SAMLIDPSSOSESSIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMLIDPSPSESSION_WHERE);

			query.append(_FINDER_COLUMN_SAMLIDPSSOSESSIONID_SAMLIDPSSOSESSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(samlIdpSsoSessionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SAMLIDPSSOSESSIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of saml idp sp sessions where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63;.
	 *
	 * @param samlIdpSsoSessionId the saml idp sso session ID
	 * @param samlSpEntityId the saml sp entity ID
	 * @return the number of matching saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySISSI_SSEI(long samlIdpSsoSessionId, String samlSpEntityId)
		throws SystemException {
		Object[] finderArgs = new Object[] { samlIdpSsoSessionId, samlSpEntityId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SISSI_SSEI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMLIDPSPSESSION_WHERE);

			query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLIDPSSOSESSIONID_2);

			if (samlSpEntityId == null) {
				query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_1);
			}
			else {
				if (samlSpEntityId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_3);
				}
				else {
					query.append(_FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(samlIdpSsoSessionId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SISSI_SSEI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of saml idp sp sessions.
	 *
	 * @return the number of saml idp sp sessions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SAMLIDPSPSESSION);

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
	 * Initializes the saml idp sp session persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.saml.model.SamlIdpSpSession")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SamlIdpSpSession>> listenersList = new ArrayList<ModelListener<SamlIdpSpSession>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SamlIdpSpSession>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SamlIdpSpSessionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = SamlIdpSpSessionPersistence.class)
	protected SamlIdpSpSessionPersistence samlIdpSpSessionPersistence;
	@BeanReference(type = SamlIdpSsoSessionPersistence.class)
	protected SamlIdpSsoSessionPersistence samlIdpSsoSessionPersistence;
	@BeanReference(type = SamlSpAuthRequestPersistence.class)
	protected SamlSpAuthRequestPersistence samlSpAuthRequestPersistence;
	@BeanReference(type = SamlSpMessagePersistence.class)
	protected SamlSpMessagePersistence samlSpMessagePersistence;
	@BeanReference(type = SamlSpSessionPersistence.class)
	protected SamlSpSessionPersistence samlSpSessionPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SAMLIDPSPSESSION = "SELECT samlIdpSpSession FROM SamlIdpSpSession samlIdpSpSession";
	private static final String _SQL_SELECT_SAMLIDPSPSESSION_WHERE = "SELECT samlIdpSpSession FROM SamlIdpSpSession samlIdpSpSession WHERE ";
	private static final String _SQL_COUNT_SAMLIDPSPSESSION = "SELECT COUNT(samlIdpSpSession) FROM SamlIdpSpSession samlIdpSpSession";
	private static final String _SQL_COUNT_SAMLIDPSPSESSION_WHERE = "SELECT COUNT(samlIdpSpSession) FROM SamlIdpSpSession samlIdpSpSession WHERE ";
	private static final String _FINDER_COLUMN_SAMLIDPSSOSESSIONID_SAMLIDPSSOSESSIONID_2 =
		"samlIdpSpSession.samlIdpSsoSessionId = ?";
	private static final String _FINDER_COLUMN_SISSI_SSEI_SAMLIDPSSOSESSIONID_2 = "samlIdpSpSession.samlIdpSsoSessionId = ? AND ";
	private static final String _FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_1 = "samlIdpSpSession.samlSpEntityId IS NULL";
	private static final String _FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_2 = "samlIdpSpSession.samlSpEntityId = ?";
	private static final String _FINDER_COLUMN_SISSI_SSEI_SAMLSPENTITYID_3 = "(samlIdpSpSession.samlSpEntityId IS NULL OR samlIdpSpSession.samlSpEntityId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "samlIdpSpSession.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SamlIdpSpSession exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SamlIdpSpSession exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SamlIdpSpSessionPersistenceImpl.class);
	private static SamlIdpSpSession _nullSamlIdpSpSession = new SamlIdpSpSessionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SamlIdpSpSession> toCacheModel() {
				return _nullSamlIdpSpSessionCacheModel;
			}
		};

	private static CacheModel<SamlIdpSpSession> _nullSamlIdpSpSessionCacheModel = new CacheModel<SamlIdpSpSession>() {
			public SamlIdpSpSession toEntityModel() {
				return _nullSamlIdpSpSession;
			}
		};
}