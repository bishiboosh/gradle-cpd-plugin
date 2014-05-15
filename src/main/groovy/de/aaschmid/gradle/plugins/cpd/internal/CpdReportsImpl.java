package de.aaschmid.gradle.plugins.cpd.internal;

import de.aaschmid.gradle.plugins.cpd.Cpd;
import de.aaschmid.gradle.plugins.cpd.CpdCsvFileReport;
import de.aaschmid.gradle.plugins.cpd.CpdReports;
import de.aaschmid.gradle.plugins.cpd.CpdTextFileReport;
import org.gradle.api.reporting.SingleFileReport;
import org.gradle.api.reporting.internal.TaskGeneratedSingleFileReport;
import org.gradle.api.reporting.internal.TaskReportContainer;

public class CpdReportsImpl extends TaskReportContainer<SingleFileReport> implements CpdReports {

    public CpdReportsImpl(Cpd task) {
        super(SingleFileReport.class, task);

        add(CpdCsvFileReportImpl.class, "csv", task);
        add(CpdTextFileReportImpl.class, "text", task);
        add(TaskGeneratedSingleFileReport.class, "xml", task);
    }

    @Override
    public CpdCsvFileReport getCsv() {
        return (CpdCsvFileReport) getByName("csv");
    }

    @Override
    public CpdTextFileReport getText() {
        return (CpdTextFileReport) getByName("text");
    }

    @Override
    public SingleFileReport getXml() {
        return getByName("xml");
    }
}
