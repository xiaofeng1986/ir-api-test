package bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ImageAnalysisRequestBodyBean {

    private String businessId ;
    private String storeName;
    private String storeNo;
    private String province;
    private String city;
    private String area;
    private String address;
    private String lat;
    private String lgt;
    private String salesId;
    private String salesName;
    private String imgUrl;
    private String storeType;
    private String sceneCategoryOne;
    private String sceneCategoryTwo;
    private String photoTime;
    private String dataSource;
    private String isSplice;
    private String isAiQuality;
    private String authorization;
    private String distributorName;
    private String distributorNo;

    private static final String BUSINESS_ID_KEY = "businessId";
    private static final String STORE_NAME_KEY = "storeName";
    private static final String STORE_NO_KEY = "storeNo";
    private static final String PROVINCE_KEY = "province";
    private static final String CITY_KEY = "city";
    private static final String AREA_KEY = "area";
    private static final String ADDRESS_KEY = "address";
    private static final String LAT_KEY = "lat";
    private static final String LGT_KEY = "lgt";
    private static final String SALES_ID_KEY = "salesId";
    private static final String SALES_NAME_KEY = "salesName";
    private static final String IMG_URL_KEY = "imgUrl";
    private static final String STORE_TYPE_KEY = "storeType";
    private static final String SCENE_CATEGORY_ONE_KEY = "sceneCategoryOne";
    private static final String SCENE_CATEGORY_TWO_KEY = "sceneCategoryTwo";
    private static final String PHOTO_TIME_KEY = "photoTime";
    private static final String DATA_SOURCES_KEY = "dataSources";
    private static final String IS_SPLICE_KEY = "isSplice";
    private static final String IS_AI_QUALITY_KEY = "isAiQuality";
    private static final String AUTHORIZATION_KEY = "authorization";
    private static final String DISTRIBUTOR_NAME_KEY = "distributorName";
    private static final String DISTRIBUTOR_NO_KEY = "distributorNo";

    public ImageAnalysisRequestBodyBean() {

        authorization = "Ym4NMkE75yLDCLiVy7s9dAJxiAPFwzdUtB";
    }
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLgt() {
        return lgt;
    }

    public void setLgt(String lgt) {
        this.lgt = lgt;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getSceneCategoryOne() {
        return sceneCategoryOne;
    }

    public void setSceneCategoryOne(String sceneCategoryOne) {
        this.sceneCategoryOne = sceneCategoryOne;
    }

    public String getSceneCategoryTwo() {
        return sceneCategoryTwo;
    }

    public void setSceneCategoryTwo(String sceneCategoryTwo) {
        this.sceneCategoryTwo = sceneCategoryTwo;
    }

    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getIsSplice() {
        return isSplice;
    }

    public void setIsSplice(String isSplice) {
        this.isSplice = isSplice;
    }

    public String getIsAiQuality() {
        return isAiQuality;
    }

    public void setIsAiQuality(String isAiQuality) {
        this.isAiQuality = isAiQuality;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getDistributorNo() {
        return distributorNo;
    }

    public void setDistributorNo(String distributorNo) {
        this.distributorNo = distributorNo;
    }

    public String toJSONObject () {
        Map<String,String> requestBodyMap = new HashMap<String,String>();
        requestBodyMap.put(BUSINESS_ID_KEY,businessId);
        requestBodyMap.put(STORE_NAME_KEY,storeName);
        requestBodyMap.put(STORE_NO_KEY,storeNo);
        requestBodyMap.put(PROVINCE_KEY,province);
        requestBodyMap.put(CITY_KEY,city);
        requestBodyMap.put(AREA_KEY,area);
        requestBodyMap.put(ADDRESS_KEY,address);
        requestBodyMap.put(LAT_KEY,lat);
        requestBodyMap.put(LGT_KEY,lgt);
        requestBodyMap.put(SALES_ID_KEY,salesId);
        requestBodyMap.put(SALES_NAME_KEY,salesName);
        requestBodyMap.put(IMG_URL_KEY,imgUrl);
        requestBodyMap.put(STORE_TYPE_KEY,storeType);
        requestBodyMap.put(SCENE_CATEGORY_ONE_KEY,sceneCategoryOne);
        requestBodyMap.put(SCENE_CATEGORY_TWO_KEY,sceneCategoryTwo);
        requestBodyMap.put(PHOTO_TIME_KEY,photoTime);
        requestBodyMap.put(DATA_SOURCES_KEY,dataSource);
        requestBodyMap.put(IS_SPLICE_KEY,isSplice);
        requestBodyMap.put(IS_AI_QUALITY_KEY,isAiQuality);
        requestBodyMap.put(AUTHORIZATION_KEY,authorization);
        requestBodyMap.put(DISTRIBUTOR_NO_KEY,distributorNo);
        requestBodyMap.put(DISTRIBUTOR_NAME_KEY,distributorName);

        GsonBuilder gsonMapBuilder = new GsonBuilder();
        Gson gsonObject = gsonMapBuilder.create();
        String JSONObject = gsonObject.toJson(requestBodyMap);
        System.out.println("JSONObject: " + JSONObject);
        return JSONObject;
    }
}

