package com.gdut.software.mapper;

/**
 * @author 22427(king0liam)
 * @version 1.0
 * @ClassName: PaperListMapper
 * @Description
 * @Date: 2021/12/2 21:14
 * @since version-0.0
 */

import com.gdut.software.entity.PaperList;
import com.gdut.software.entity.QueryInfo;
import org.apache.ibatis.annotations.Mapper;
import com.gdut.software.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Mapper
public interface PaperListMapper {
//    List<PaperList>getPaperList(int id);
    List<PaperList> getPaperList();

    List<Question> getPaper(@Param("paperId") int paperId);

    int updatePaperList(@Param("tableName")String tableName, @Param("identityList")  List<Map<String, Object>> identityList, @Param("columnName") Map<String, Object> columnName);

    int deletePaper(@Param("paperId") int paperId);

    int addPaperList(PaperList paperList);

    PaperList getPaperListById(int id);

    List<PaperList> getPaperOfAnalyse(QueryInfo queryInfo);

    int deletePaperListById(int id);

    List<String> getPaperKinds();
}
