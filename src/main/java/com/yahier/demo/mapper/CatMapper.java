package com.yahier.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yahier.demo.table.Cat;
import org.springframework.stereotype.Service;

@Service
public interface CatMapper extends BaseMapper<Cat> {
}
