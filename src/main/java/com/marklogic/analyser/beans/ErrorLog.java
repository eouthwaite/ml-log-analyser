package com.marklogic.analyser.beans;

import java.util.List;
import java.util.Map;

/**
 * TODO - Describe
 * <p/>
 * User: Alex
 * Date: 05/05/15
 * Time: 14:02
 */
public class ErrorLog {

    private String name;
    private List<String> errorLogTxt;
    private Map<String, List<String>> occurrenceMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getErrorLogTxt() {
        return errorLogTxt;
    }

    public List<String> getErrorLogHead() {
        if (errorLogTxt.size() > 10000) return errorLogTxt.subList(0, 10000);
        else return getErrorLogTxt();
    }

    public void setErrorLogTxt(List<String> errorLogTxt) {
        this.errorLogTxt = errorLogTxt;
    }

    public Map<String, List<String>> getOccurrenceMap() {
        return occurrenceMap;
    }

    public void setOccurrenceMap(Map<String, List<String>> occurrenceMap) {
        this.occurrenceMap = occurrenceMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorLog errorLog = (ErrorLog) o;

        if (!errorLogTxt.equals(errorLog.errorLogTxt)) return false;
        if (!name.equals(errorLog.name)) return false;
        if (!occurrenceMap.equals(errorLog.occurrenceMap)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + errorLogTxt.hashCode();
        result = 31 * result + occurrenceMap.hashCode();
        return result;
    }
}