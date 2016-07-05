package edu.bjtu.dao;

import edu.bjtu.model.Product;

import java.util.List;

/**
 * Created by zhangxuan on 2016/7/4.
 */
public interface ProductDao {
    public void addProduct(Product product);
    public List<Product> queryProduct();
    public boolean delete(String name);
    public boolean update(Product product);
}
