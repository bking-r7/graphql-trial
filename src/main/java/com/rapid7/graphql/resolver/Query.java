/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.resolver;

import com.rapid7.graphql.model.ScanEngine;
import com.rapid7.graphql.model.Site;
import com.rapid7.graphql.service.DBService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 * TODO: Describe Me!
 */
public class Query implements GraphQLQueryResolver
{
   private DBService dbService;

   public Query(DBService dbService)
   {
      this.dbService = dbService;
   }

   public Iterable<Site> findAllSites()
   {
      return dbService.findAllSites();
   }

   public Iterable<ScanEngine> findAllScanEngines()
   {
      return dbService.findAllScanEngines();
   }

   public long countSites()
   {
      return dbService.countSites();
   }

   public long countScanEngines()
   {
      return dbService.countScanEngines();
   }
}