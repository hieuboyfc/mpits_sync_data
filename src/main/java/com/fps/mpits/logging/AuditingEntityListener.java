package com.fps.mpits.logging;

import com.fps.mpits.request.RequestScope;
import com.fps.mpits.util.*;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 * @see <a href="http://www.baeldung.com/database-auditing-jpa"></a>
 */

@Component
public class AuditingEntityListener {

    @PrePersist
    public void onPrePersist(Object objInput) {
        beforeAnyOperation(objInput, Constant.JpaEvent.ON_PRE_PERSIST);
    }

    @PreUpdate
    public void onPreUpdate(Object objInput) {
        beforeAnyOperation(objInput, Constant.JpaEvent.ON_PRE_UPDATE);
    }

    @PreRemove
    public void onPreRemove(Object objInput) {
        beforeAnyOperation(objInput, Constant.JpaEvent.ON_PRE_REMOVE);
    }

    private void beforeAnyOperation(Object objInput, String sJpaEvent) {
        try {
            // Gán giá trị cho Entity MCAS_AUDIT_LOG
            RequestScope requestScope = BeanUtil.getBean(RequestScope.class);
            McasAuditLogEntity mcasAuditLogEntity = new McasAuditLogEntity();

            mcasAuditLogEntity.id(0);
            mcasAuditLogEntity.appCode(Constant.AuditLog.APP_CODE);
            mcasAuditLogEntity.menuCode(Constant.AuditLog.MENI_CODE);
            mcasAuditLogEntity.funcCode(Constant.AuditLog.FUNCTION_CODE);
            mcasAuditLogEntity.actionUser(Constant.AuditLog.MPITS);
            mcasAuditLogEntity.actionDt(new Date());
            mcasAuditLogEntity.actionData(Jackson.getInstance().object2String(objInput));
            mcasAuditLogEntity.tableName(objInput.getClass().getAnnotation(Table.class).name());
            mcasAuditLogEntity.jpaEvent(sJpaEvent);
            mcasAuditLogEntity.ipAddress(requestScope.ipAddress());
            mcasAuditLogEntity.userAgent(requestScope.userAgent());
            mcasAuditLogEntity.urlRequest(requestScope.urlRequest());
            mcasAuditLogEntity.urlReferer(requestScope.urlReferer());

            IMcasAuditLogRepository mcasAuditLogRepository = BeanUtil.getBean(IMcasAuditLogRepository.class);
            mcasAuditLogRepository.save(mcasAuditLogEntity);
        } catch (Exception e) {
            Common.getStackTrace(e);
        }
    }
}
