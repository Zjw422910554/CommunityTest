package com.nowcoder.community1.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by a4229 on 2021/1/28 14:37.
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate null";
    }
}
