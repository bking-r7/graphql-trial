/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.resolver;

import com.rapid7.graphql.model.ScanEngine;
import com.rapid7.graphql.model.Site;
import com.rapid7.graphql.service.DBService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import java.util.UUID;

/**
 * TODO: Describe Me!
 */
public class Mutation implements GraphQLMutationResolver
{
   private DBService dbService;

   public Mutation(DBService dbService)
   {
      this.dbService = dbService;
   }


   public Site newSite(String name, String location)
   {
      return dbService.newSite(name, location);
   }

   public ScanEngine newScanEngine(UUID engineUuid, String state, String nextAction, Boolean isPaired, Long siteId)
   {
      return dbService.newScanEngine(engineUuid, state, nextAction, isPaired, siteId);
   }

   public boolean deleteScanEngine(Long id) {
      dbService.deleteScanEngine(id);
      return true;
   }

   public ScanEngine updateScanEngineIsPaired(Boolean isPaired, Long id) {
      return dbService.updateScanEngineIsPaired(isPaired, id);
   }
}
