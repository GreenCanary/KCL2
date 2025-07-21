package com.mike.kcl2;

public class Material {
    //solid phase section
    private double calculatedH2O = 0;
    private double mSolid = 0;
    private double mLiquid = 0;
    private double slRatio = 0;


    private double s_KCl_p = 0;
    private double s_KCl_v = 0;
    private double s_NaCl_p = 0;
    private double s_NaCl_v = 0;
    private double s_CaSO4_p = 0;
    private double s_CaSO4_v = 0;
    private double s_Check_p = 0;
    private double s_Check_v = 0;



    //liquid phase section
    private double l_KCl_p = 0;
    private double l_KCl_v = 0;
    private double l_NaCl_p = 0;
    private double l_NaCl_v = 0;
    private double l_CaSO4_p = 0;
    private double l_CaSO4_v = 0;
    private double H2O_p = 0;
    private double H2O_v = 0;
    private double l_Check_p = 0;
    private double l_Check_v = 0;
    private double moist = 0;


    public double getS_KCl_p() {
        return s_KCl_p;
    }

    public void setS_KCl_p(double s_KCl_p) {
        this.s_KCl_p = s_KCl_p;
    }

    public double getS_KCl_v() {
        return s_KCl_v;
    }

    public void setS_KCl_v(double s_KCl_v) {
        this.s_KCl_v = s_KCl_v;
    }

    public double getS_NaCl_p() {
        return s_NaCl_p;
    }

    public void setS_NaCl_p(double s_NaCl_p) {
        this.s_NaCl_p = s_NaCl_p;
    }

    public double getS_NaCl_v() {
        return s_NaCl_v;
    }

    public void setS_NaCl_v(double s_NaCl_v) {
        this.s_NaCl_v = s_NaCl_v;
    }

    public double getS_CaSO4_p() {
        return s_CaSO4_p;
    }

    public void setS_CaSO4_p(double s_CaSO4_p) {
        this.s_CaSO4_p = s_CaSO4_p;
    }

    public double getS_CaSO4_v() {
        return s_CaSO4_v;
    }

    public void setS_CaSO4_v(double s_CaSO4_v) {
        this.s_CaSO4_v = s_CaSO4_v;
    }

    public double getS_Check_p() {
        return s_Check_p;
    }

    public void setS_Check_p(double s_Check_p) {
        this.s_Check_p = s_Check_p;
    }

    public double getS_Check_v() {
        return s_Check_v;
    }

    public void setS_Check_v(double s_Check_v) {
        this.s_Check_v = s_Check_v;
    }

    public double getL_KCl_p() {
        return l_KCl_p;
    }

    public void setL_KCl_p(double l_Kcl_p) {
        this.l_KCl_p = l_Kcl_p;
    }

    public double getL_KCl_v() {
        return l_KCl_v;
    }

    public void setL_KCl_v(double l_KCl_v) {
        this.l_KCl_v = l_KCl_v;
    }

    public double getL_NaCl_p() {
        return l_NaCl_p;
    }

    public void setL_NaCl_p(double l_NaCl_p) {
        this.l_NaCl_p = l_NaCl_p;
    }

    public double getL_NaCl_v() {
        return l_NaCl_v;
    }

    public void setL_NaCl_v(double l_NaCl_v) {
        this.l_NaCl_v = l_NaCl_v;
    }

    public double getL_CaSO4_p() {
        return l_CaSO4_p;
    }

    public void setL_CaSO4_p(double l_CaSO4_p) {
        this.l_CaSO4_p = l_CaSO4_p;
    }

    public double getL_CaSO4_v() {
        return l_CaSO4_v;
    }

    public void setL_CaSO4_v(double l_CaSO4_v) {
        this.l_CaSO4_v = l_CaSO4_v;
    }

    public double getH2O_p() {
        return H2O_p;
    }

    public void setH2O_p(double h2O_p) {
        H2O_p = h2O_p;
    }

    public double getH2O_v() {
        return H2O_v;
    }

    public void setH2O_v(double h2O_v) {
        H2O_v = h2O_v;
    }

    public double getL_Check_p() {
        return l_Check_p;
    }

    public void setL_Check_p(double l_Check_p) {
        this.l_Check_p = l_Check_p;
    }

    public double getL_Check_v() {
        return l_Check_v;
    }

    public void setL_Check_v(double l_Check_v) {
        this.l_Check_v = l_Check_v;
    }

    public double getmSolid() {
        return mSolid;
    }

    public void setmSolid(double mSolid) {
        this.mSolid = mSolid;
    }

    public double getSlRatio() {
        return slRatio;
    }

    public void setSlRatio(double slRatio) {
        this.slRatio = slRatio;
    }

    public double getmLiquid() {
        return mLiquid;
    }

    public void setmLiquid(double mLiquid) {
        this.mLiquid = mLiquid;
    }

    public double getMoist() {
        return moist;
    }

    public void setMoist(double moist) {
        this.moist = moist;
    }

    public double getCalculatedH2O() {
        return calculatedH2O;
    }

    public void setCalculatedH2O(double calculatedH2O) {
        this.calculatedH2O = calculatedH2O;
    }
}
