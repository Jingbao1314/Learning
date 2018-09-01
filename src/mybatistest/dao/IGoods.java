package mybatistest.dao;

import mybatistest.pojo.Goods;

import java.util.List;

/**
 * Created by jingbao on 18-8-31.
 */
public interface IGoods {
    public List<Goods> getGoodsList();
}
