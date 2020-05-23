package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ParameterInfo implements Serializable {
    private int algorithmId;
    private String[] parameterNames;
    private String[] parameterDescriptions;
    private String[] parameterInputDefaultValues;
    private String[] parameterOptionDefaultValues;
    private String[] parameterTypes;
    private String[] parameterSettingInfoTypes;
    private String[]  parameterSettingInfoValues;


    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String[] getParameterNames() {
        return parameterNames;
    }

    public void setParameterNames(String[] parameterNames) {
        this.parameterNames = parameterNames;
    }

    public String[] getParameterDescriptions() {
        return parameterDescriptions;
    }

    public void setParameterDescriptions(String[] parameterDescriptions) {
        this.parameterDescriptions = parameterDescriptions;
    }

    public String[] getParameterInputDefaultValues() {
        return parameterInputDefaultValues;
    }

    public void setParameterInputDefaultValues(String[] parameterInputDefaultValues) {
        this.parameterInputDefaultValues = parameterInputDefaultValues;
    }

    public String[] getParameterOptionDefaultValues() {
        return parameterOptionDefaultValues;
    }

    public void setParameterOptionDefaultValues(String[] parameterOptionDefaultValues) {
        this.parameterOptionDefaultValues = parameterOptionDefaultValues;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String[] getParameterSettingInfoTypes() {
        return parameterSettingInfoTypes;
    }

    public void setParameterSettingInfoTypes(String[] parameterSettingInfoTypes) {
        this.parameterSettingInfoTypes = parameterSettingInfoTypes;
    }


    public String[] getParameterSettingInfoValues() {
        return parameterSettingInfoValues;
    }

    public void setParameterSettingInfoValues(String[] parameterSettingInfoValues) {
        this.parameterSettingInfoValues = parameterSettingInfoValues;
    }

    @Override
    public String toString() {
        return "ParameterInfo{" +
                "algorithmId=" + algorithmId +
                ", parameterNames=" + Arrays.toString(parameterNames) +
                ", parameterDescriptions=" + Arrays.toString(parameterDescriptions) +
                ", parameterInputDefaultValues=" + Arrays.toString(parameterInputDefaultValues) +
                ", parameterOptionDefaultValues=" + Arrays.toString(parameterOptionDefaultValues) +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", parameterSettingInfoTypes=" + Arrays.toString(parameterSettingInfoTypes) +
                ", parameterSettingInfoValues=" + Arrays.toString(parameterSettingInfoValues) +
                '}';
    }
}