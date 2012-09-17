package org.stefaniuk.json.service.example4.model;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * <p>
 * MVCS abstract data access object.
 * </p>
 * 
 * @author Daniel Stefaniuk
 * @version 1.1.0
 * @since 2012/09/02
 */
public abstract class AbstractModelDao<M> extends NamedParameterJdbcDaoSupport {

    protected final Logger logger = LoggerFactory.getLogger(AbstractModelDao.class);

    /** Table name */
    protected final String TABLE_NAME;

    /**
     * Constructor
     */
    public AbstractModelDao() {

        // get table name
        TABLE_NAME = getModelClass().getAnnotation(ModelTable.class).name();
    }

    /**
     * Saves model.
     * 
     * @param model
     * @return Integer
     */
    public abstract Integer create(M model);

    /**
     * Updates model.
     * 
     * @param model
     * @return Integer
     */
    public abstract Integer update(M model);

    /**
     * Updates model.
     * 
     * @param model
     * @return Integer
     */
    public abstract Integer update(M model, M changed);

    /**
     * Removes model.
     * 
     * @param model
     * @return Integer
     */
    public abstract Integer remove(M model);

    /**
     * Returns all models.
     * 
     * @return List of models.
     */
    public abstract List<M> findAll();

    /**
     * Returns model by given id.
     * 
     * @param id
     * @return Model
     */
    public abstract M findById(Integer id);

    /**
     * Returns id by given model.
     * 
     * @param model
     * @return Integer
     */
    public abstract Integer findIdByModel(M model);

    /**
     * Counts all models.
     * 
     * @return Integer
     */
    public abstract Integer countAll();

    /**
     * Returns class of model.
     * 
     * @return Class<M>
     */
    @SuppressWarnings("unchecked")
    private Class<M> getModelClass() {

        return (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
