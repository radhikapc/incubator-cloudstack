// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.cloudstack.utils;

import java.util.List;
import java.util.Map;

public class QemuImg {

    /* Shouldn't we have KVMPhysicalDisk and LibvirtVMDef read this? */
    public static enum PhysicalDiskFormat {
        RAW("raw"), QCOW2("qcow2");
        String format;

        private PhysicalDiskFormat(String format) {
            this.format = format;
        }

        public String toString() {
            return this.format;
        }
    }

    /* These are all methods supported by the qemu-img tool */

    /* Perform a consistency check on the disk image */
    public static void check() {

    }

    /* Create a new disk image */
    public static void create(String filename, long size, PhysicalDiskFormat format, List<Map<String, String>> options) {

    }

    public static void create(String filename, long size, PhysicalDiskFormat format) {
        QemuImg.create(filename, size, format, null);
    }

    /* Convert the disk image filename or a snapshot snapshot_name to disk image output_filename using format output_fmt. */
    public static void convert() {

    }

    /* Commit the changes recorded in filename in its base image */
    public static void commit(String filename, PhysicalDiskFormat format) {

    }

    public static void commit(String filename) {
        QemuImg.commit(filename, null);
    }

    /* Give information about the disk image */
    public static void info(String filename, PhysicalDiskFormat format) {

    }

    public static void info(String filename) {
        QemuImg.info(filename, null);
    }

    /* List, apply, create or delete snapshots in image */
    public static void snapshot() {

    }

    /* Changes the backing file of an image */
    public static void rebase() {

    }

    /* Resize a disk image */
    public static void resize(String filename, long size) {
        String newSize = null;
        if (size > 0) {
            newSize = "+" + size;
        } else {
            newSize = "-" + size;
        }
    }

}