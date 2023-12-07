package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmInsDto;
import com.green.greengram3.dm.model.DmMsgSelDto;
import com.green.greengram3.dm.model.DmMsgSelVo;
import com.green.greengram3.dm.model.DmUserInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    //----------------------- t_dm
    int insDm(DmInsDto dto);

    //----------------------- t_dm_user
    int insDmuser(DmUserInsDto dto);

    //----------------------- t_dm_msg
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);
}
