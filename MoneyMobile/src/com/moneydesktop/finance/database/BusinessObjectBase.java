package com.moneydesktop.finance.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.moneydesktop.finance.ApplicationContext;
import com.moneydesktop.finance.data.Constant;
import com.moneydesktop.finance.data.DataController;
import com.moneydesktop.finance.data.Enums.DataState;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table BUSINESS_OBJECT_BASE.
 */
public class BusinessObjectBase extends BusinessObject  {

    private Long id;
    private Integer dataState;
    private java.util.Date dateModified;
    private String errorCode;
    private String externalId;
    private Integer flags;
    private String primaryKey;
    private String toString;
    private Integer version;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BusinessObjectBaseDao myDao;

    private List<TagInstance> tagInstances;

    // KEEP FIELDS - put your custom fields here
    
    private QueryProperty mBusinessObjectBase = new QueryProperty(BusinessObjectBaseDao.TABLENAME, TagInstanceDao.Properties.BusinessObjectId, BusinessObjectBaseDao.Properties.Id);
    private QueryProperty mTag = new QueryProperty(TagDao.TABLENAME, TagInstanceDao.Properties.TagId, TagDao.Properties.Id);
    private QueryProperty mBaseObjectId = new QueryProperty(TagInstanceDao.TABLENAME, TagInstanceDao.Properties.BaseObjectId);
    private QueryProperty mDataState = new QueryProperty(BusinessObjectBaseDao.TABLENAME, BusinessObjectBaseDao.Properties.DataState, QueryProperty.NOT_EQUALS);
    private QueryProperty mTagName = new QueryProperty(TagDao.TABLENAME, TagDao.Properties.TagName);
    
    private static Long idCount = null;
    // KEEP FIELDS END

    public BusinessObjectBase() {
    }

    public BusinessObjectBase(Long id) {
        this.id = id;
    }

    public BusinessObjectBase(Long id, Integer dataState, java.util.Date dateModified, String errorCode, String externalId, Integer flags, String primaryKey, String toString, Integer version) {
        this.id = id;
        this.dataState = dataState;
        this.dateModified = dateModified;
        this.errorCode = errorCode;
        this.externalId = externalId;
        this.flags = flags;
        this.primaryKey = primaryKey;
        this.toString = toString;
        this.version = version;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBusinessObjectBaseDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public java.util.Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(java.util.Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public synchronized List<TagInstance> getTagInstances() {
        if (tagInstances == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TagInstanceDao targetDao = daoSession.getTagInstanceDao();
            tagInstances = targetDao._queryBusinessObjectBase_TagInstances(id);
        }
        return tagInstances;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetTagInstances() {
        tagInstances = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
	
	public boolean hasSession() {
		return daoSession != null;
	}

	public long getBusinessObjectId() {
		return 0;
	}

	public void setBusinessObjectId(long businessObjectId) {}

	public BusinessObjectBase getBusinessObjectBase() {
		return null;
	}

	public void setBusinessObjectBase(BusinessObjectBase businessObjectBase) {}
	
	public static synchronized Long nextId() {
		
		if (idCount == null) {
		    
		    SQLiteDatabase db = ApplicationContext.getDb();
		    Cursor cursor = db.rawQuery(Constant.QUERY_BOB_ID, new String[] {});
	        
	        cursor.moveToFirst();
	        idCount = cursor.getLong(0) + 1;
	        
	        cursor.close();
		}
		
		return idCount++;
	}
	
	public static BusinessObjectBase getBusinessObjectBase(long id) {
	    BusinessObjectBaseDao bobDao = (BusinessObjectBaseDao) DataController.getDao(BusinessObjectBase.class);
	    return bobDao.load(id);
	}
    
    public JSONObject getJson() {
    	return null;
    }
    
    public List<Tag> getTags() {
    	
        TagInstanceDao tagInstanceDao = ApplicationContext.getDaoSession().getTagInstanceDao();
        TagDao tagDao = ApplicationContext.getDaoSession().getTagDao();

        PowerQuery query = new PowerQuery(tagInstanceDao);
        query.join(mBusinessObjectBase)
        	.join(mTag)
            .where(mBaseObjectId, Long.toString(getId())).and()
            .where(mDataState, Integer.toString(DataState.DATA_STATE_DELETED.index()))
            .orderBy(mTagName, false);
        
        List<TagInstance> tagInstances = tagInstanceDao.queryRaw(query.toString(), query.getSelectionArgs());
        
        List<Tag> tags = new ArrayList<Tag>();
        
        for (TagInstance ti : tagInstances) {
        	tags.add(tagDao.load(ti.getTagId()));
        }
        
        return tags;
        
    }
    
	public boolean containsTag(String tagId) {

		for (TagInstance ti : getTagInstances()) {
			
			if (ti.getDataStateEnum() != DataState.DATA_STATE_DELETED && ti.getTag().getTagId().equals(tagId))
				return true;
		}
		
		return false;
	}
    // KEEP METHODS END

}
