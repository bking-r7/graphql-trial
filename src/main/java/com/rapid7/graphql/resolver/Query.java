/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.resolver;

import com.rapid7.graphql.model.ScanEngine;
import com.rapid7.graphql.model.Site;
import com.rapid7.graphql.repository.ScanEngineRepository;
import com.rapid7.graphql.repository.SiteRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 * TODO: Describe Me!
 */
public class Query implements GraphQLQueryResolver
{
   private ScanEngineRepository scanEngineRepository;
   private SiteRepository siteRepository;

   public Query(SiteRepository siteRepository, ScanEngineRepository scanEngineRepository)
   {
      this.siteRepository = siteRepository;
      this.scanEngineRepository = scanEngineRepository;
   }

   public Iterable<Site> findAllSites()
   {
      return siteRepository.findAll();
   }

   public Iterable<ScanEngine> findAllScanEngines()
   {
      return scanEngineRepository.findAll();
   }

//   public long countSites()
//   {
//      return siteRepository.count();
//   }
//
//   public long countScanEngines()
//   {
//      return scanEngineRepository.count();
//   }
}