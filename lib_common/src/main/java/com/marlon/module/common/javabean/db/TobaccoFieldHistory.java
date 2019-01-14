package com.marlon.module.common.javabean.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @desc TobaccoFieldHistory
 * @author Marlon
 * @date 2019/1/9
 */
@Entity
public class TobaccoFieldHistory  {
    @Id(autoincrement = true)
    private Long id;
    /** Not-null value. */
    private String iId;
    private String iYear;
    private String fieldGroupCode;
    private String farmerGroupCode;
    private String farmerName;
    private String farmerCode;
    private String farmerCallNumber;
    private String areaContract;
    private String transplant;
    private String ownerName;
    private String ownerGroupCode;
    private String ownerCallNumber;
    private String sStage;
    private String adminUserPer;
    private String cStatus;
    private String lngLat;
    private String areaReal;
    private String cType;
    private String feature;
    private String soilType;
    private String ownerAddress;
    private String ownerLngLat;
    private String farmerAddress;
    private String farmerLnglat;
    private Integer synchronize;

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    public String getiYear() {
        return iYear;
    }

    public void setiYear(String iYear) {
        this.iYear = iYear;
    }

    public String getsStage() {
        return sStage;
    }

    public void setsStage(String sStage) {
        this.sStage = sStage;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public TobaccoFieldHistory() {
    }

    public TobaccoFieldHistory(Long id) {
        this.id = id;
    }

    @Generated(hash = 1609283793)
    public TobaccoFieldHistory(Long id, String iId, String iYear, String fieldGroupCode,
            String farmerGroupCode, String farmerName, String farmerCode, String farmerCallNumber,
            String areaContract, String transplant, String ownerName, String ownerGroupCode,
            String ownerCallNumber, String sStage, String adminUserPer, String cStatus, String lngLat,
            String areaReal, String cType, String feature, String soilType, String ownerAddress,
            String ownerLngLat, String farmerAddress, String farmerLnglat, Integer synchronize) {
        this.id = id;
        this.iId = iId;
        this.iYear = iYear;
        this.fieldGroupCode = fieldGroupCode;
        this.farmerGroupCode = farmerGroupCode;
        this.farmerName = farmerName;
        this.farmerCode = farmerCode;
        this.farmerCallNumber = farmerCallNumber;
        this.areaContract = areaContract;
        this.transplant = transplant;
        this.ownerName = ownerName;
        this.ownerGroupCode = ownerGroupCode;
        this.ownerCallNumber = ownerCallNumber;
        this.sStage = sStage;
        this.adminUserPer = adminUserPer;
        this.cStatus = cStatus;
        this.lngLat = lngLat;
        this.areaReal = areaReal;
        this.cType = cType;
        this.feature = feature;
        this.soilType = soilType;
        this.ownerAddress = ownerAddress;
        this.ownerLngLat = ownerLngLat;
        this.farmerAddress = farmerAddress;
        this.farmerLnglat = farmerLnglat;
        this.synchronize = synchronize;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getIId() {
        return iId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIId(String iId) {
        this.iId = iId;
    }


    public String getIYear() {
        return iYear;
    }

    public void setIYear(String iYear) {
        this.iYear = iYear;
    }

    public String getFieldGroupCode() {
        return fieldGroupCode;
    }

    public void setFieldGroupCode(String fieldGroupCode) {
        this.fieldGroupCode = fieldGroupCode;
    }

    public String getFarmerGroupCode() {
        return farmerGroupCode;
    }

    public void setFarmerGroupCode(String farmerGroupCode) {
        this.farmerGroupCode = farmerGroupCode;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerCode() {
        return farmerCode;
    }

    public void setFarmerCode(String farmerCode) {
        this.farmerCode = farmerCode;
    }



    public String getFarmerCallNumber() {
        return farmerCallNumber;
    }

    public void setFarmerCallNumber(String farmerCallNumber) {
        this.farmerCallNumber = farmerCallNumber;
    }

    public String getAreaContract() {
        return areaContract;
    }

    public void setAreaContract(String areaContract) {
        this.areaContract = areaContract;
    }

    public String getTransplant() {
        return transplant;
    }

    public void setTransplant(String transplant) {
        this.transplant = transplant;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerGroupCode() {
        return ownerGroupCode;
    }

    public void setOwnerGroupCode(String ownerGroupCode) {
        this.ownerGroupCode = ownerGroupCode;
    }

    public String getOwnerCallNumber() {
        return ownerCallNumber;
    }

    public void setOwnerCallNumber(String ownerCallNumber) {
        this.ownerCallNumber = ownerCallNumber;
    }

    public String getSStage() {
        return sStage;
    }

    public void setSStage(String sStage) {
        this.sStage = sStage;
    }

    public String getAdminUserPer() {
        return adminUserPer;
    }

    public void setAdminUserPer(String adminUserPer) {
        this.adminUserPer = adminUserPer;
    }

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getLngLat() {
        return lngLat;
    }

    public void setLngLat(String lngLat) {
        this.lngLat = lngLat;
    }

    public String getAreaReal() {
        return areaReal;
    }

    public void setAreaReal(String areaReal) {
        this.areaReal = areaReal;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerLngLat() {
        return ownerLngLat;
    }

    public void setOwnerLngLat(String ownerLngLat) {
        this.ownerLngLat = ownerLngLat;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    public String getFarmerLnglat() {
        return farmerLnglat;
    }

    public void setFarmerLnglat(String farmerLnglat) {
        this.farmerLnglat = farmerLnglat;
    }

    public Integer getSynchronize() {
        return synchronize;
    }

    public void setSynchronize(Integer synchronize) {
        this.synchronize = synchronize;
    }

}
