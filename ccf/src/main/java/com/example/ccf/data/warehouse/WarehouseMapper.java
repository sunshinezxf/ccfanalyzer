package com.example.ccf.data.warehouse;

import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface WarehouseMapper {

    /**
     * get Private Paper by userId
     *
     * @param user_id
     * @return List<Paper>
     */
    List<Paper> getUserPrivatePaper(@Param("user_id")int user_id);

    /**
     * get Private Paper by teamId
     *
     * @param team_id
     * @return List<Paper>
     */
    List<Paper> getTeamPrivatePaper(@Param("team_id")int team_id);

    /**
     * delete private paper by paperId
     *
     * @param paper_id
     * @return void
     */
    void deletePrivatePaper(@Param("paper_id")int paper_id);

    /**
     * delete private paper user relation by paperId
     *
     * @param paper_id
     * @return void
     */
    void deleteUserRelation(@Param("paper_id")int paper_id);

    /**
     * delete private paper team relation by paperId
     *
     * @param paper_id
     * @return void
     */
    void deleteTeamRelation(@Param("paper_id")int paper_id);

    /**
     * get Private Paper authors by paperId
     *
     * @param paper_id
     * @return List<Paper>
     */
    List<String> getPrivatePaperAuthors(@Param("paper_id")int paper_id);
}
