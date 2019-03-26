package com.ywj.springcloud.mapper;

import com.ywj.springcloud.entities.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DictMapper {
/**    
    *@Description:   用于基础数据的类别查询
    * @Param: [dict]
    * @return: java.util.List<com.ywj.springcloud.entities.Dict>
    * @Author: ywj
    * @Date: 2019/3/26 0026
    */
    List<Dict> loadDict(Dict dict);


}
