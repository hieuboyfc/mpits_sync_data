package com.fps.mpits.modules.cate.repo;

import com.fps.mpits.modules.cate.eo.McasAdministrativeUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

@Repository
public interface IMcasAdministrativeUnitRepository extends JpaRepository<McasAdministrativeUnitEntity, String> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE MCAS_ADMINISTRATIVE_UNIT t " +
                    "SET t.IS_FAR = :isFar, t.IS_ISLAND = :isIsLand " +
                    "WHERE t.CODE IN (SELECT u.CODE FROM MCAS_ADMINISTRATIVE_UNIT u CONNECT BY PRIOR u.CODE = u.PARENT_CODE START WITH u.CODE = :code)")
    void updateIsFarAndIsLand(@Param("code") String code,
                              @Param("isFar") Integer isFar,
                              @Param("isIsLand") Integer isIsLand);

}