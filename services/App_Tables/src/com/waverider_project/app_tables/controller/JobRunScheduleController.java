/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.waverider_project.app_tables.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.waverider_project.app_tables.JobRunSchedule;
import com.waverider_project.app_tables.service.JobRunScheduleService;


/**
 * Controller object for domain model class JobRunSchedule.
 * @see JobRunSchedule
 */
@RestController("App_Tables.JobRunScheduleController")
@Api(value = "JobRunScheduleController", description = "Exposes APIs to work with JobRunSchedule resource.")
@RequestMapping("/App_Tables/JobRunSchedule")
public class JobRunScheduleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobRunScheduleController.class);

    @Autowired
	@Qualifier("App_Tables.JobRunScheduleService")
	private JobRunScheduleService jobRunScheduleService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new JobRunSchedule instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public JobRunSchedule createJobRunSchedule(@RequestBody JobRunSchedule jobRunSchedule) {
		LOGGER.debug("Create JobRunSchedule with information: {}" , jobRunSchedule);

		jobRunSchedule = jobRunScheduleService.create(jobRunSchedule);
		LOGGER.debug("Created JobRunSchedule with information: {}" , jobRunSchedule);

	    return jobRunSchedule;
	}

    @ApiOperation(value = "Returns the JobRunSchedule instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public JobRunSchedule getJobRunSchedule(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting JobRunSchedule with id: {}" , id);

        JobRunSchedule foundJobRunSchedule = jobRunScheduleService.getById(id);
        LOGGER.debug("JobRunSchedule details with id: {}" , foundJobRunSchedule);

        return foundJobRunSchedule;
    }

    @ApiOperation(value = "Updates the JobRunSchedule instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public JobRunSchedule editJobRunSchedule(@PathVariable("id") Integer id, @RequestBody JobRunSchedule jobRunSchedule) {
        LOGGER.debug("Editing JobRunSchedule with id: {}" , jobRunSchedule.getId());

        jobRunSchedule.setId(id);
        jobRunSchedule = jobRunScheduleService.update(jobRunSchedule);
        LOGGER.debug("JobRunSchedule details with id: {}" , jobRunSchedule);

        return jobRunSchedule;
    }
    
    @ApiOperation(value = "Partially updates the JobRunSchedule instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public JobRunSchedule patchJobRunSchedule(@PathVariable("id") Integer id, @RequestBody @MapTo(JobRunSchedule.class) Map<String, Object> jobRunSchedulePatch) {
        LOGGER.debug("Partially updating JobRunSchedule with id: {}" , id);

        JobRunSchedule jobRunSchedule = jobRunScheduleService.partialUpdate(id, jobRunSchedulePatch);
        LOGGER.debug("JobRunSchedule details after partial update: {}" , jobRunSchedule);

        return jobRunSchedule;
    }

    @ApiOperation(value = "Deletes the JobRunSchedule instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteJobRunSchedule(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting JobRunSchedule with id: {}" , id);

        JobRunSchedule deletedJobRunSchedule = jobRunScheduleService.delete(id);

        return deletedJobRunSchedule != null;
    }

    /**
     * @deprecated Use {@link #findJobRunSchedules(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of JobRunSchedule instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<JobRunSchedule> searchJobRunSchedulesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering JobRunSchedules list by query filter:{}", (Object) queryFilters);
        return jobRunScheduleService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of JobRunSchedule instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<JobRunSchedule> findJobRunSchedules(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering JobRunSchedules list by filter:", query);
        return jobRunScheduleService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of JobRunSchedule instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<JobRunSchedule> filterJobRunSchedules(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering JobRunSchedules list by filter", query);
        return jobRunScheduleService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportJobRunSchedules(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return jobRunScheduleService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportJobRunSchedulesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = JobRunSchedule.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> jobRunScheduleService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of JobRunSchedule instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countJobRunSchedules( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting JobRunSchedules");
		return jobRunScheduleService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getJobRunScheduleAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return jobRunScheduleService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service JobRunScheduleService instance
	 */
	protected void setJobRunScheduleService(JobRunScheduleService service) {
		this.jobRunScheduleService = service;
	}

}