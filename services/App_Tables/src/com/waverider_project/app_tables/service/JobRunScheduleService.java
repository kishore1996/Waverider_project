/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.waverider_project.app_tables.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.waverider_project.app_tables.JobRunSchedule;

/**
 * Service object for domain model class {@link JobRunSchedule}.
 */
public interface JobRunScheduleService {

    /**
     * Creates a new JobRunSchedule. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JobRunSchedule if any.
     *
     * @param jobRunSchedule Details of the JobRunSchedule to be created; value cannot be null.
     * @return The newly created JobRunSchedule.
     */
    JobRunSchedule create(@Valid JobRunSchedule jobRunSchedule);


	/**
     * Returns JobRunSchedule by given id if exists.
     *
     * @param jobrunscheduleId The id of the JobRunSchedule to get; value cannot be null.
     * @return JobRunSchedule associated with the given jobrunscheduleId.
	 * @throws EntityNotFoundException If no JobRunSchedule is found.
     */
    JobRunSchedule getById(Integer jobrunscheduleId);

    /**
     * Find and return the JobRunSchedule by given id if exists, returns null otherwise.
     *
     * @param jobrunscheduleId The id of the JobRunSchedule to get; value cannot be null.
     * @return JobRunSchedule associated with the given jobrunscheduleId.
     */
    JobRunSchedule findById(Integer jobrunscheduleId);

	/**
     * Find and return the list of JobRunSchedules by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param jobrunscheduleIds The id's of the JobRunSchedule to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return JobRunSchedules associated with the given jobrunscheduleIds.
     */
    List<JobRunSchedule> findByMultipleIds(List<Integer> jobrunscheduleIds, boolean orderedReturn);


    /**
     * Updates the details of an existing JobRunSchedule. It replaces all fields of the existing JobRunSchedule with the given jobRunSchedule.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JobRunSchedule if any.
     *
     * @param jobRunSchedule The details of the JobRunSchedule to be updated; value cannot be null.
     * @return The updated JobRunSchedule.
     * @throws EntityNotFoundException if no JobRunSchedule is found with given input.
     */
    JobRunSchedule update(@Valid JobRunSchedule jobRunSchedule);


    /**
     * Partially updates the details of an existing JobRunSchedule. It updates only the
     * fields of the existing JobRunSchedule which are passed in the jobRunSchedulePatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JobRunSchedule if any.
     *
     * @param jobrunscheduleId The id of the JobRunSchedule to be deleted; value cannot be null.
     * @param jobRunSchedulePatch The partial data of JobRunSchedule which is supposed to be updated; value cannot be null.
     * @return The updated JobRunSchedule.
     * @throws EntityNotFoundException if no JobRunSchedule is found with given input.
     */
    JobRunSchedule partialUpdate(Integer jobrunscheduleId, Map<String, Object> jobRunSchedulePatch);

    /**
     * Deletes an existing JobRunSchedule with the given id.
     *
     * @param jobrunscheduleId The id of the JobRunSchedule to be deleted; value cannot be null.
     * @return The deleted JobRunSchedule.
     * @throws EntityNotFoundException if no JobRunSchedule found with the given id.
     */
    JobRunSchedule delete(Integer jobrunscheduleId);

    /**
     * Deletes an existing JobRunSchedule with the given object.
     *
     * @param jobRunSchedule The instance of the JobRunSchedule to be deleted; value cannot be null.
     */
    void delete(JobRunSchedule jobRunSchedule);

    /**
     * Find all JobRunSchedules matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching JobRunSchedules.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<JobRunSchedule> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all JobRunSchedules matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching JobRunSchedules.
     *
     * @see Pageable
     * @see Page
     */
    Page<JobRunSchedule> findAll(String query, Pageable pageable);

    /**
     * Exports all JobRunSchedules matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all JobRunSchedules matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the JobRunSchedules in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the JobRunSchedule.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}