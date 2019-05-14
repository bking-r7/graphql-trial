/***************************************************************************
 * COPYRIGHT (C) 2019, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package com.rapid7.graphql.resolver;

import com.rapid7.graphql.model.ScanEngine;
import com.rapid7.graphql.model.Site;
import com.rapid7.graphql.repository.SiteRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

/**
 * TODO: Describe Me!
 */
public class ScanEngineResolver implements GraphQLResolver<ScanEngine>
{
   private SiteRepository siteRepository;

   public ScanEngineResolver(SiteRepository siteRepository) {
      this.siteRepository = siteRepository;
   }

   public Site getSite(ScanEngine scanEngine) {
      long id = scanEngine.getSite().getId();
      return siteRepository.findById(id).get();
   }
}