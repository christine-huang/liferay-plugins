/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.workflow.kaleo.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KaleoNode service. Represents a row in the &quot;KaleoNode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. All helper methods and application logic should be put in {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeImpl}.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a kaleo node model instance should use the {@link KaleoNode} interface instead.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       KaleoNode
 * @see       com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeImpl
 * @see       com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl
 * @generated
 */
public interface KaleoNodeModel extends BaseModel<KaleoNode> {
	/**
	 * Gets the primary key of this kaleo node.
	 *
	 * @return the primary key of this kaleo node
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo node
	 *
	 * @param pk the primary key of this kaleo node
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the kaleo node id of this kaleo node.
	 *
	 * @return the kaleo node id of this kaleo node
	 */
	public long getKaleoNodeId();

	/**
	 * Sets the kaleo node id of this kaleo node.
	 *
	 * @param kaleoNodeId the kaleo node id of this kaleo node
	 */
	public void setKaleoNodeId(long kaleoNodeId);

	/**
	 * Gets the group id of this kaleo node.
	 *
	 * @return the group id of this kaleo node
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this kaleo node.
	 *
	 * @param groupId the group id of this kaleo node
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this kaleo node.
	 *
	 * @return the company id of this kaleo node
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this kaleo node.
	 *
	 * @param companyId the company id of this kaleo node
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this kaleo node.
	 *
	 * @return the user id of this kaleo node
	 */
	public long getUserId();

	/**
	 * Sets the user id of this kaleo node.
	 *
	 * @param userId the user id of this kaleo node
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this kaleo node.
	 *
	 * @return the user uuid of this kaleo node
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this kaleo node.
	 *
	 * @param userUuid the user uuid of this kaleo node
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this kaleo node.
	 *
	 * @return the user name of this kaleo node
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this kaleo node.
	 *
	 * @param userName the user name of this kaleo node
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this kaleo node.
	 *
	 * @return the create date of this kaleo node
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo node.
	 *
	 * @param createDate the create date of this kaleo node
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this kaleo node.
	 *
	 * @return the modified date of this kaleo node
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo node.
	 *
	 * @param modifiedDate the modified date of this kaleo node
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the kaleo definition id of this kaleo node.
	 *
	 * @return the kaleo definition id of this kaleo node
	 */
	public long getKaleoDefinitionId();

	/**
	 * Sets the kaleo definition id of this kaleo node.
	 *
	 * @param kaleoDefinitionId the kaleo definition id of this kaleo node
	 */
	public void setKaleoDefinitionId(long kaleoDefinitionId);

	/**
	 * Gets the name of this kaleo node.
	 *
	 * @return the name of this kaleo node
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this kaleo node.
	 *
	 * @param name the name of this kaleo node
	 */
	public void setName(String name);

	/**
	 * Gets the description of this kaleo node.
	 *
	 * @return the description of this kaleo node
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this kaleo node.
	 *
	 * @param description the description of this kaleo node
	 */
	public void setDescription(String description);

	/**
	 * Gets the type of this kaleo node.
	 *
	 * @return the type of this kaleo node
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this kaleo node.
	 *
	 * @param type the type of this kaleo node
	 */
	public void setType(String type);

	/**
	 * Gets the initial of this kaleo node.
	 *
	 * @return the initial of this kaleo node
	 */
	public boolean getInitial();

	/**
	 * Determines whether this kaleo node is initial.
	 *
	 * @return whether this kaleo node is initial
	 */
	public boolean isInitial();

	/**
	 * Sets the initial of this kaleo node.
	 *
	 * @param initial the initial of this kaleo node
	 */
	public void setInitial(boolean initial);

	/**
	 * Gets the terminal of this kaleo node.
	 *
	 * @return the terminal of this kaleo node
	 */
	public boolean getTerminal();

	/**
	 * Determines whether this kaleo node is terminal.
	 *
	 * @return whether this kaleo node is terminal
	 */
	public boolean isTerminal();

	/**
	 * Sets the terminal of this kaleo node.
	 *
	 * @param terminal the terminal of this kaleo node
	 */
	public void setTerminal(boolean terminal);

	/**
	 * Gets a copy of this kaleo node as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public KaleoNode toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(KaleoNode kaleoNode);

	public int hashCode();

	public String toString();

	public String toXmlString();
}