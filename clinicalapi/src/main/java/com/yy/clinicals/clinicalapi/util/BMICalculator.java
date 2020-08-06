package com.yy.clinicals.clinicalapi.util;

import com.yy.clinicals.clinicalapi.Entity.ClinicalData;

import java.util.List;

public class BMICalculator {

    public static void calculateBMI(List<ClinicalData> clinicalData, ClinicalData c) {
        if (c.getComponentName().equals("hw")) {
            String[] handw = c.getComponentValue().split("/");
            if (handw != null && handw.length > 1) {
                float heightInmetres = Float.parseFloat(handw[0]) * 0.4536F;
                float bmi = Float.parseFloat(handw[1]) / (heightInmetres * heightInmetres);
                ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentValue("bmi");
                bmiData.setComponentValue(Float.toString(bmi));
                clinicalData.add(bmiData);
            }
        }
    }
}
