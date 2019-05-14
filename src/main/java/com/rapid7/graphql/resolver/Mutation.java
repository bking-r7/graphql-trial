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
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import java.util.UUID;

/**
 * TODO: Describe Me!
 */
public class Mutation implements GraphQLMutationResolver
{
   private SiteRepository siteRepository;
   private ScanEngineRepository scanEngineRepository;

   public Mutation(SiteRepository siteRepository, ScanEngineRepository scanEngineRepository)
   {
      this.siteRepository = siteRepository;
      this.scanEngineRepository = scanEngineRepository;
   }

   public Site newSite(String name, String location)
   {
      Site site = new Site();
      site.setName(name);
      site.setLocation(location);

      siteRepository.save(site);

      return site;
   }

   public ScanEngine newScanEngine(UUID engineUuid, String state, String nextAction, Boolean isPaired, Long siteId)
   {
      ScanEngine scanEngine = new ScanEngine();
      scanEngine.setEngineUuid(engineUuid);
      scanEngine.setState(state);
      scanEngine.setNextAction(nextAction);
      scanEngine.setIsPaired(isPaired);
      scanEngine.setSite(new Site(siteId));

      scanEngineRepository.save(scanEngine);

      return scanEngine;
   }

   public boolean deleteScanEngine(Long id) {
      scanEngineRepository.deleteById(id);
      return true;
   }

   public ScanEngine updateScanEngineIsPaired(Boolean isPaired, Long id) {
      ScanEngine scanEngine = scanEngineRepository.findById(id).get();
      scanEngine.setIsPaired(isPaired);

      scanEngineRepository.save(scanEngine);

      return scanEngine;
   }
}
