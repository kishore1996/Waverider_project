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

import com.waverider_project.app_tables.JobRunHistory;

/**
 * Service object for domain model class {@link JobRunHistory}.
 */
public interface JobRunHistoryService {

    /**
     * Creates a new JobRunHistory. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JobRunHistory if any.
     *
     * @param jobRunHistory Details of the JobRunHistory to be created; value cannot be null.
     * @return The newly created JobRunHistory.
     */
    JobRunHistory create(@Valid JobRunHistory jobRunHistory);


	/**
     * Returns JobRunHistory by given id if exists.
     *
     * @param jobrunhistoryId The id of the JobRunHistory to get; value cannot be null.
     * @return JobRunHistory associated with the given jobrunhistoryId.
	 * @throws EntityNotFoundException If no JobRunHistory is found.
     */
    JobRunHistory getById(Integer jobrunhistoryId);

    /**
     * Find and return the JobRunHistory by given id if exists, returns null otherwise.
     *
     * @param jobrunhistoryId The id of the JobRunHistory to get; value cannot be null.
     * @return JobRunHistory associated with the given jobrunhistoryId.
     */
    JobRunHistory findById(Integer jobrunhistoryId);

	/**
     * Find and return the list of JobRunHistories by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param jobrunhistoryIds The id's of the JobRunHistory to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return JobRunHistories associated with the given jobrunhistoryIds.
     */
    List<JobRunHistory> findByMultipleIds(List<Integer> jobrunhistoryIds, boolean orderedReturn);


    /**
     * Updates the details of an existing JobRunHistory. It replaces all fields of the existing JobRunHistory with the given jobRunHistory.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JobRunHistory if any.
     *
     * @param jobRunHistory The details of the JobRunHistory to be updated; value cannot be null.
     * @return The updated JobRunHistory.
     * @throws EntityNotFoundException if no JobRunHistory is found with given input.
     */
    JobRunHistory update(@Valid JobRunHistory jobRunHistory);


    /**
     * Partially updates the details of an existing JobRunHistory. It updates only the
     * fields of the existing JobRunHistory which are passed in the jobRunHistoryPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on JobRunHistory if any.
     *
     * @param jobrunhistoryId The id of the JobRunHistory to be deleted; value cannot be null.
     * @param jobRunHistoryPatch The partial data of JobRunHistory which is supposed to be updated; value cannot be null.
     * @return The updated JobRunHistory.
     * @throws EntityNotFoundException if no JobRunHistory is found with given input.
     */
    JobRunHistory partialUpdate(Integer jobrunhistoryId, Map<String, Object> jobRunHistoryPatch);

    /**
     * Deletes an existing JobRunHistory with the given id.
     *
     * @param jobrunhistoryId The id of the JobRunHistory to be deleted; value cannot be null.
     * @return The deleted JobRunHistory.
     * @throws EntityNotFoundException if no JobRunHistory found with the given id.
     */
    JobRunHistory delete(Integer jobrunhistoryId);

    /**
     * Deletes an existing JobRunHistory with the given object.
     *
     * @param jobRunHistory The instance of the JobRunHistory to be deleted; value cannot be null.
     */
    void delete(JobRunHistory jobRunHistory);

    /**
     * Find all JobRunHistories matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching JobRunHistories.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<JobRunHistory> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all JobRunHistories matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching JobRunHistories.
     *
     * @see Pageable
     * @see Page
     */
    Page<JobRunHistory> findAll(String query, Pageable pageable);

    /**
     * Exports all JobRunHistories matching the given input query to the given exportType format.
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
     * Exports all JobRunHistories matching the given input query to the given exportType format.
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
     * Retrieve the count of the JobRunHistories in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the JobRunHistory.
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