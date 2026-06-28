package com.travelai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelai.domain.Trip;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TripMapper extends BaseMapper<Trip> {
}
