// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.storage.pool;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.cloud.api.commands.CancelPrimaryStorageMaintenanceCmd;
import com.cloud.api.commands.CreateStoragePoolCmd;
import com.cloud.api.commands.CreateVolumeCmd;
import com.cloud.api.commands.DeletePoolCmd;
import com.cloud.api.commands.ListVolumesCmd;
import com.cloud.api.commands.UpdateStoragePoolCmd;
import com.cloud.api.commands.UploadVolumeCmd;
import com.cloud.dc.DataCenterVO;
import com.cloud.dc.HostPodVO;
import com.cloud.exception.ConcurrentOperationException;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.PermissionDeniedException;
import com.cloud.exception.ResourceAllocationException;
import com.cloud.exception.ResourceInUseException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.storage.StoragePoolVO;
import com.cloud.storage.volume.Volume;
import com.cloud.vm.DiskProfile;
import com.cloud.vm.VMInstanceVO;

public interface StoragePoolService {
    /**
     * Create StoragePool based on uri
     * 
     * @param cmd
     *            the command object that specifies the zone, cluster/pod, URI, details, etc. to use to create the
     *            storage pool.
     * @return
     * @throws ResourceInUseException
     * @throws IllegalArgumentException
     * @throws UnknownHostException
     * @throws ResourceUnavailableException
     */
    StoragePool createPool(CreateStoragePoolCmd cmd) throws ResourceInUseException, IllegalArgumentException, 
    UnknownHostException, ResourceUnavailableException;
    
    /**
     * Delete the storage pool
     * 
     * @param cmd
     *            - the command specifying poolId
     * @return success or failure
     */
    boolean deletePool(DeletePoolCmd cmd);
    
    /**
     * Enable maintenance for storage
     * 
     * @param cmd
     *            - the command specifying primaryStorageId
     * @return the primary storage pool
     * @throws ResourceUnavailableException
     * @throws InsufficientCapacityException
     */
    public StoragePool prepareStorageForMaintenance(Long primaryStorageId) throws ResourceUnavailableException, 
    InsufficientCapacityException;
    
    /**
     * Complete maintenance for primary storage
     * 
     * @param cmd
     *            - the command specifying primaryStorageId
     * @return the primary storage pool
     * @throws ResourceUnavailableException
     */
    public StoragePool cancelStorageForMaintenance(CancelPrimaryStorageMaintenanceCmd cmd) 
            throws ResourceUnavailableException;

    
    
    //TODO: Need to move around for this following APIs
    public StoragePool updateStoragePool(UpdateStoragePoolCmd cmd) throws IllegalArgumentException;

    public StoragePool getStoragePool(long id);
}
