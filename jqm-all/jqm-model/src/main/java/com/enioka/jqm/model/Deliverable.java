/**
 * Copyright © 2013 enioka. All rights reserved
 * Authors: Marc-Antoine GOUILLART (marc-antoine.gouillart@enioka.com)
 *          Pierre COPPEE (pierre.coppee@enioka.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enioka.jqm.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enioka.jqm.jdbc.DatabaseException;
import com.enioka.jqm.jdbc.DbConn;

/**
 * <strong>Not part of any API - this an internal JQM class and may change without notice.</strong> <br>
 * Persistence class for storing pointers towards files created by {@link JobInstance}.
 */
public class Deliverable implements Serializable
{
    private static final long serialVersionUID = 4803101067798401977L;

    protected Integer id;

    protected String filePath;

    protected String fileFamily;

    private Integer jobId;

    private String randomId;

    private String originalFileName;

    /**
     * This is an optional classification tag. Max length is 100.
     */
    public String getFileFamily()
    {
        return fileFamily;
    }

    /**
     * See {@link #getFileFamily()}
     */
    public void setFileFamily(final String fileFamily)
    {
        this.fileFamily = fileFamily;
    }

    /**
     * ID of the {@link JobInstance} which created this {@link Deliverable}. This is also the ID of the {@link History} object once the
     * {@link JobInstance} has finished (and therefore disappeared)
     */
    public Integer getJobId()
    {
        return jobId;
    }

    /**
     * See {@link #getJobId()}
     */
    public void setJobId(final Integer jobId)
    {

        this.jobId = jobId;
    }

    /**
     * Path of the file where it can be retrieved. It is relative to {@link Node#getDlRepo()}
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * See {@link #getFilePath()}
     */
    public void setFilePath(final String filePath)
    {

        this.filePath = filePath;
    }

    /**
     * A technical ID without any meaning. Generated by the database.
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * Should never be called. See {@link #getId()}
     */
    void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * The name of the file that was created by the {@link JobInstance}, before it was renamed to avoid file name collisions. This name is
     * stored as a precaution, but it is better to use {@link #getFileFamily()} to tag files with a meaningful name.
     */
    public String getOriginalFileName()
    {
        return originalFileName;
    }

    /**
     * See {@link #getOriginalFileName()}
     */
    public void setOriginalFileName(String originalFileName)
    {
        this.originalFileName = originalFileName;
    }

    /**
     * Each {@link Deliverable} is associated to a stable random UUID. This UUID can be used to retrieve the file through the servlet API.
     * (this in turn enables some 'security' through obscurity, as file names cannot be guessed easily)
     */
    public String getRandomId()
    {
        return randomId;
    }

    /**
     * See {@link #getRandomId()}
     */
    public void setRandomId(String randomId)
    {
        this.randomId = randomId;
    }

    public void validate()
    {
        if (filePath.length() > 1024)
        {
            throw new ValidationException("filePath", "must be shorter than 1024 characters");
        }
        if (fileFamily.length() > 100)
        {
            throw new ValidationException("fileFamily", "must be shorter than 100 characters");
        }
        if (jobId == null)
        {
            throw new ValidationException("jobId", "cannot be null");
        }
        if (randomId == null)
        {
            throw new ValidationException("randomId", "cannot be null");
        }

    }

    public static List<Deliverable> select(DbConn cnx, String query_key, Object... args)
    {
        List<Deliverable> res = new ArrayList<Deliverable>();
        try
        {
            ResultSet rs = cnx.runSelect(query_key, args);
            while (rs.next())
            {
                Deliverable tmp = new Deliverable();

                tmp.id = rs.getInt(1);
                tmp.fileFamily = rs.getString(2);
                tmp.filePath = rs.getString(3);
                tmp.jobId = rs.getInt(4);
                tmp.originalFileName = rs.getString(5);
                tmp.randomId = rs.getString(6);

                res.add(tmp);
            }
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e);
        }
        return res;
    }
}
