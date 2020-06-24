package com.fps.mpits.rest;

import com.fps.mpits.exception.BadRequestException;
import com.fps.mpits.exception.NotAcceptableException;
import com.fps.mpits.modules.app.eo.McasApplicationEntity;
import com.fps.mpits.modules.app.eo.McasListApproveDataEntity;
import com.fps.mpits.modules.auth.eo.*;
import com.fps.mpits.modules.cate.eo.*;
import com.fps.mpits.modules.cate_rate_postal.eo.*;
import com.fps.mpits.request.RequestClientInfo;
import com.fps.mpits.request.RequestScope;
import com.fps.mpits.response.SyncResponse;
import com.fps.mpits.util.BeanUtil;
import com.fps.mpits.util.Constant;
import com.fps.mpits.util.Jackson;
import com.fps.mpits.util.TOTP;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@RestController
@RequestMapping(value = Constant.RestController.URL_JOB_SYNC)
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SyncDataRestController {

    @PersistenceContext
    protected EntityManager entityManagerSync;

    /**
     * excuteOther - excute other app (endpoint to rest)
     */
    @PostMapping(Constant.RestController.EXCUTE_OTHER)
    public ResponseEntity<List<SyncResponse>> excuteOther(@RequestParam String totp,
                                                          @Valid @RequestBody List<McasListApproveDataEntity> lstMcasListApproveDataEntity,
                                                          HttpServletRequest request) {
        // Xác thực TOTP
        if (!TOTP.getInstance().checkTOTP(Constant.RestController.EXCUTE_OTHER, totp,
                Constant.SyncProperties.EXPIRATION_IN_MS, Constant.SyncProperties.CODE_DIGITS))
            throw new BadRequestException(String.format(Constant.RestController.AUTH_JOB, totp));

        // Kiểm tra dữ liệu của danh sách duyệt có tồn tại không
        if (lstMcasListApproveDataEntity == null || lstMcasListApproveDataEntity.isEmpty())
            throw new BadRequestException(Constant.ExceptionText.NOT_FOUND_LIST_APPROVE_DATA);

        Object objEntity;
        List<SyncResponse> responses = new ArrayList<>();
        for (McasListApproveDataEntity item : lstMcasListApproveDataEntity) {
            SyncResponse syncResponse = new SyncResponse();
            syncResponse.id(item.id());
            syncResponse.type((byte) 1);
            syncResponse.message(String.format(Constant.ExceptionText.SYNC_DATA_SUCCESS, item.id(), item.listType()));
            switch (item.listType()) {
                case Constant.EntityTable.MCAS_APPLICATION:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasApplicationEntity.class);
                    break;
                case Constant.EntityTable.MCAS_EMPLOYEE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasEmployeeEntity.class);
                    break;
                case Constant.EntityTable.MCAS_USER:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasUserEntity.class);
                    break;
                case Constant.EntityTable.MCAS_USER_GROUP:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasUserGroupEntity.class);
                    break;
                case Constant.EntityTable.MCAS_USER_APP:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasUserAppEntity.class);
                    break;
                case Constant.EntityTable.MCAS_USER_APP_STATUS:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasUserAppStatusEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ROLE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasRoleEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ORGANIZATION:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasOrganizationEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ORGANIZATION_STANDARD:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasOrganizationStandardEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ORGANIZATION_TYPE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasOrganizationTypeEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ADMINISTRATIVE_UNIT:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasAdministrativeUnitEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ADMINISTRATIVE_POSTCODE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasAdministrativePostCodeEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ADMINISTRATIVE_SEARCH:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasAdministrativeSearchEntity.class);
                    break;
                case Constant.EntityTable.MCAS_NATIONAL:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasNationalEntity.class);
                    break;
                case Constant.EntityTable.MCAS_NATIONAL_CITY:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasNationalCityEntity.class);
                    break;
                case Constant.EntityTable.MCAS_NATIONAL_POSTAL:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasNationalPostalEntity.class);
                    break;
                case Constant.EntityTable.MCAS_EXCHANGE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasExchangeEntity.class);
                    break;
                case Constant.EntityTable.MCAS_EXCHANGE_RATE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasExchangeRateEntity.class);
                    break;
                case Constant.EntityTable.MCAS_POSTOFFICE_MAPPING:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasPostOfficeMappingEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ITEM_GROUP:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasItemGroupEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ITEM_TYPE_SERVICE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasItemTypeServiceEntity.class);
                    break;
                case Constant.EntityTable.MCAS_ITEM_TYPE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasItemTypeEntity.class);
                    break;
                case Constant.EntityTable.MCAS_FEE_TYPE_GROUP:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasFeeTypeGroupEntity.class);
                    break;
                case Constant.EntityTable.MCAS_FEE_TYPE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasFeeTypeEntity.class);
                    break;
                case Constant.EntityTable.MCAS_SERVICE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasServiceEntity.class);
                    break;
                case Constant.EntityTable.MCAS_SERVICE_GROUP:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasServiceGroupEntity.class);
                    break;
                case Constant.EntityTable.MCAS_VA_SERVICE:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasVaServiceEntity.class);
                    break;
                case Constant.EntityTable.MCAS_SERVICE_VAS:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasServiceVasEntity.class);
                    break;
                case Constant.EntityTable.MCAS_UOM:
                    objEntity = Jackson.getInstance().string2Object(item.listData(), McasUomEntity.class);
                    break;
                default:
                    syncResponse.message(Constant.ExceptionText.NOT_FOUND_TABLE);
                    syncResponse.type((byte) 0);
                    throw new NotAcceptableException(Constant.ExceptionText.NOT_FOUND_TABLE);
            }
            if (objEntity == null) {
                syncResponse.message(String.format(Constant.ExceptionText.DATA_TABLE_IS_NULL, item.listType()));
                syncResponse.type((byte) 0);
                throw new BadRequestException(String.format(Constant.ExceptionText.DATA_TABLE_IS_NULL, item.listType()));
            }
            if (!push2Db(item.listType(), item.listAction(), objEntity)) {
                syncResponse.message(String.format(Constant.ExceptionText.PUSH_DATA_TABLE_TO_DB, item.listType()));
                syncResponse.type((byte) 0);
                throw new BadRequestException(String.format(Constant.ExceptionText.PUSH_DATA_TABLE_TO_DB, item.listType()));
            }
            responses.add(syncResponse);
            System.out.println(String.format(Constant.ExceptionText.PUSH_DATA_TABLE_SUCCESS, item.listType(), item.id(), item.listAction()));

            // Lấy thông tin từ request để lưu vào bảng MCAS_AUDIT_LOG
            RequestScope requestScope = BeanUtil.getBean(RequestScope.class);
            requestScope.userAgent(RequestClientInfo.getInstance().getUserAgent(request));
            requestScope.ipAddress(RequestClientInfo.getInstance().getClientIpAddr(request));
            requestScope
                    .urlRequest(RequestClientInfo.getInstance().getUrlWithQueryString(request));
            requestScope.urlReferer(RequestClientInfo.getInstance().getReferer(request));
            requestScope.clientOS(RequestClientInfo.getInstance().getClientOS(request));
            requestScope.clientBrowser(RequestClientInfo.getInstance().getClientBrowser(request));
            requestScope.identifyDevice(RequestClientInfo.getInstance().getIdentifyDevice(request));
            requestScope.cookie(RequestClientInfo.getInstance().getCookieValueByName(request,
                    Constant.SyncProperties.COOKIE_API_KEY));
        }
        return ResponseEntity.ok().body(responses);
    }

    /**
     * push2Db - push to db
     *
     * @return T
     */
    protected <T> boolean push2Db(String listType, String listAction, T objEntity) {
        McasUserAppEntity mcasUserAppEntity = null;
        if (listType.equals(Constant.EntityTable.MCAS_USER_APP)) {
            mcasUserAppEntity = (McasUserAppEntity) objEntity;
            if (mcasUserAppEntity.lstMcasEmployeeEntity() != null
                    && !mcasUserAppEntity.lstMcasEmployeeEntity().isEmpty()) {
                for (McasEmployeeEntity e : mcasUserAppEntity.lstMcasEmployeeEntity()) {
                    push2Db(listAction, e);
                }
            }
            if (mcasUserAppEntity.lstMcasUserEntity() != null
                    && !mcasUserAppEntity.lstMcasUserEntity().isEmpty()) {
                for (McasUserEntity u : mcasUserAppEntity.lstMcasUserEntity()) {
                    push2Db(listAction, u);
                }
            }
        }
        return push2Db(listAction, objEntity);
    }

    /**
     * push2Db - push to db
     */
    protected <T> boolean push2Db(String listAction, T objEntity) {
        if (StringUtils.isEmpty(listAction))
            return false;

        if (listAction.equals(Constant.JpaEvent.ON_PRE_PERSIST)
                || listAction.equals(Constant.JpaEvent.ON_PRE_UPDATE)) {
            entityManagerSync.merge(objEntity);
            return true;
        } else if (listAction.equals(Constant.JpaEvent.ON_PRE_REMOVE)) {
            entityManagerSync.remove(entityManagerSync.contains(objEntity)
                    ? objEntity : entityManagerSync.merge(objEntity));
            return true;
        }
        return false;
    }
}
