package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ParameterInfo implements Serializable {
    private int algorithmId;
    private String[] parameterNames;
    private String[] parameterDescriptions;
    private String[] parameterDefaultValues;
    private String[] parameterTypes;
    private String[][] firstParameterVales;
    private String[][] secondParameterTypes;
    private String[][] secondParameterValues;
    private String[][] firstAlgorithmParameterValues;
    private String[][] secondAlgorithmParameterValues;


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

    public String[] getParameterDefaultValues() {
        return parameterDefaultValues;
    }

    public void setParameterDefaultValues(String[] parameterDefaultValues) {
        this.parameterDefaultValues = parameterDefaultValues;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String[][] getFirstParameterVales() {
        return firstParameterVales;
    }

    public void setFirstParameterVales(String[][] firstParameterVales) {
        this.firstParameterVales = firstParameterVales;
    }

    public String[][] getSecondParameterTypes() {
        return secondParameterTypes;
    }

    public void setSecondParameterTypes(String[][] secondParameterTypes) {
        this.secondParameterTypes = secondParameterTypes;
    }

    public String[][] getSecondParameterValues() {
        return secondParameterValues;
    }

    public void setSecondParameterValues(String[][] secondParameterValues) {
        this.secondParameterValues = secondParameterValues;
    }

    public String[][] getFirstAlgorithmParameterValues() {
        return firstAlgorithmParameterValues;
    }

    public void setFirstAlgorithmParameterValues(String[][] firstAlgorithmParameterValues) {
        this.firstAlgorithmParameterValues = firstAlgorithmParameterValues;
    }

    public String[][] getSecondAlgorithmParameterValues() {
        return secondAlgorithmParameterValues;
    }

    public void setSecondAlgorithmParameterValues(String[][] secondAlgorithmParameterValues) {
        this.secondAlgorithmParameterValues = secondAlgorithmParameterValues;
    }

    @Override
    public String toString() {
        return "ParameterInfo{" +
                "algorithmId=" + algorithmId +
                ", parameterNames=" + Arrays.toString(parameterNames) +
                ", parameterDescriptions=" + Arrays.toString(parameterDescriptions) +
                ", parameterDefaultValues=" + Arrays.toString(parameterDefaultValues) +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", firstParameterVales=" + Arrays.toString(firstParameterVales) +
                ", secondParameterTypes=" + Arrays.toString(secondParameterTypes) +
                ", secondParameterValues=" + Arrays.toString(secondParameterValues) +
                ", firstAlgorithmParameterValues=" + Arrays.toString(firstAlgorithmParameterValues) +
                ", secondAlgorithmParameterValues=" + Arrays.toString(secondAlgorithmParameterValues) +
                '}';
    }
}