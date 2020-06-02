package com.fps.mpits.util;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

public class Constant {

    private Constant() {

    }

    public class EntityTable {

        // BEGIN APP
        public static final String MCAS_APPLICATION = "MCAS_APPLICATION";
        public static final String MCAS_AUDIT_LOG = "MCAS_AUDIT_LOG";
        public static final String MCAS_EMPLOYEE = "MCAS_EMPLOYEE";
        public static final String MCAS_LIST_APPROVE_DATA = "MCAS_LIST_APPROVE_DATA";
        // END APP

        // BEGIN AUTH
        public static final String MCAS_GROUP = "MCAS_GROUP";
        public static final String MCAS_USER = "MCAS_USER";
        public static final String MCAS_USER_APP = "MCAS_USER_APP";
        public static final String MCAS_USER_APP_STATUS = "MCAS_USER_APP_STATUS";
        // END AUTH

        // BEGIN CATE
        public static final String MCAS_ROLE = "MCAS_ROLE";
        public static final String MCAS_ADMINISTRATIVE_UNIT = "MCAS_ADMINISTRATIVE_UNIT";
        public static final String MCAS_NATIONAL_POSTAL = "MCAS_NATIONAL_POSTAL";
        public static final String MCAS_ORGANIZATION = "MCAS_ORGANIZATION";
        public static final String MCAS_ORGANIZATION_STANDARD = "MCAS_ORGANIZATION_STANDARD";
        public static final String MCAS_ORGANIZATION_TYPE = "MCAS_ORGANIZATION_TYPE";
        public static final String MCAS_ADMINISTRATIVE_SEARCH = "MCAS_ADMINISTRATIVE_SEARCH";
        public static final String MCAS_ADMINISTRATIVE_POSTCODE = "MCAS_ADMINISTRATIVE_POSTCODE";
        public static final String MCAS_EXCHANGE = "MCAS_EXCHANGE";
        public static final String MCAS_EXCHANGE_RATE = "MCAS_EXCHANGE_RATE";
        public static final String MCAS_NATIONAL = "MCAS_NATIONAL";
        public static final String MCAS_NATIONAL_CITY = "MCAS_NATIONAL_CITY";
        public static final String MCAS_POSTOFFICE = "MCAS_POSTOFFICE";
        public static final String MCAS_POSTOFFICE_MAPPING = "MCAS_POSTOFFICE_MAPPING";
        public static final String MCAS_ITEM_TYPE_SERVICE = "MCAS_ITEM_TYPE_SERVICE";
        public static final String MCAS_ITEM_TYPE = "MCAS_ITEM_TYPE";
        public static final String MCAS_ITEM_GROUP = "MCAS_ITEM_GROUP";
        public static final String MCAS_FEE_TYPE = "MCAS_FEE_TYPE";
        public static final String MCAS_FEE_TYPE_GROUP = "MCAS_FEE_TYPE_GROUP";
        public static final String MCAS_SERVICE = "MCAS_SERVICE";
        public static final String MCAS_SERVICE_VAS = "MCAS_SERVICE_VAS";
        public static final String MCAS_VA_SERVICE = "MCAS_VA_SERVICE";
        public static final String MCAS_UOM = "MCAS_UOM";
        // END CATE

        private EntityTable() {

        }
    }

    public class RestController {

        // BEGIN REST SYNC
        public static final String URL_JOB_SYNC = "/job/sync";
        public static final String AUTH_JOB = "Xác thực [%s] không thành công.";
        public static final String EXCUTE_OTHER = "excute/other";
        // END REST SYNC

        private RestController() {

        }
    }

    public class JpaEvent {

        // BEGIN JPA EVENT
        public static final String ON_PRE_PERSIST = "onPrePersist";
        public static final String ON_PRE_UPDATE = "onPreUpdate";
        public static final String ON_PRE_REMOVE = "onPreRemove";
        // END JPA EVENT

        private JpaEvent() {

        }
    }

    public class AuditLog {

        // BEGIN AUDIT LOG
        public static final String APP_CODE = "MCAS";
        public static final String MENI_CODE = "/job/sync/excute/other";
        public static final String FUNCTION_CODE = "SYNC DATA FROM QTTT";
        public static final String MPITS = "MPITS (Hiếu Boy)";
        // END AUDIT LOG

        private AuditLog() {

        }
    }

    public class ExceptionText {

        // BEGIN EXCEPTION TEXT
        public static final String NOT_FOUND_LIST_APPROVE_DATA = "Danh sách dữ liệu ĐỒNG BỘ trong BẢNG: McasListApproveDataEntity đang bị trống !!!";
        public static final String NOT_FOUND_TABLE = "Không tìm thấy tên BẢNG trong thư viện đồng bộ !!!";
        public static final String DATA_TABLE_IS_NULL = "Dữ liệu của BẢNG: [%s] đang bị trống !!!";
        public static final String PUSH_DATA_TABLE_TO_DB = "Đẩy dữ liệu trong BẢNG: [%s] đến DATABASE hệ thống bị lỗi !!!";
        public static final String PUSH_DATA_TABLE_SUCCESS = "Đẩy dữ liệu trong BẢNG: [%s] thành công với MÃ ĐỒNG BỘ: [%s] và HÀNH ĐỘNG: [%s]";
        public static final String SYNC_DATA_SUCCESS = "Đồng bộ thành công dữ liệu có MÃ ĐỒNG BỘ: [%s] đến BẢNG: [%s]";
        // END EXCEPTION TEXT

        private ExceptionText() {

        }
    }

    public class SyncProperties {

        // BEGIN SYNC PROPERTIES
        public static final String COOKIE_API_KEY = "cApiKey";
        public static final int CODE_DIGITS = 8; // Mã số
        public static final int EXPIRATION_IN_MS = 600000; // Thời gian hết hạn (600000 ms = 10 phút)
        // END SYNC PROPERTIES

        private SyncProperties() {

        }
    }

}
