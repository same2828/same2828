# Table of Contents

- [Table of Contents](#table-of-contents)
- [Links](#links)
- [1 - Digital Transformation with Google Cloud (GCP)](#1---digital-transformation-with-google-cloud-gcp)
  - [Why Cloud Technology is Transforming Business](#why-cloud-technology-is-transforming-business)
    - [Innovations, paradigm shifts, and digital transformation](#innovations-paradigm-shifts-and-digital-transformation)
    - [What is the Cloud](#what-is-the-cloud)
    - [IT Infrastructure implementations](#it-infrastructure-implementations)
      - [On-premises (on-prem)](#on-premises-on-prem)
      - [Private Cloud](#private-cloud)
      - [Public Cloud](#public-cloud)
      - [Hybrid Cloud](#hybrid-cloud)
      - [Multi-Cloud](#multi-cloud)
    - [Benefits of cloud computing](#benefits-of-cloud-computing)
    - [Real-world examples: Why it's critical to transform and embrace new technology](#real-world-examples-why-its-critical-to-transform-and-embrace-new-technology)
    - [Cloud eras](#cloud-eras)
    - [Challenges that lead to a digital transformation](#challenges-that-lead-to-a-digital-transformation)
    - [Google's Transformation Cloud](#googles-transformation-cloud)
      - [Data](#data)
      - [Open Infrastructure](#open-infrastructure)
    - [Google Cloud Adoption Framework](#google-cloud-adoption-framework)
    - [Quiz](#quiz)
  - [Fundamental Cloud Concepts](#fundamental-cloud-concepts)
    - [Total Cost of Ownership (TCO)](#total-cost-of-ownership-tco)
    - [Capital Expenditures (CapEx) vs Operating Expenses (OpEx)](#capital-expenditures-capex-vs-operating-expenses-opex)
    - [Private cloud, hybrid cloud, and multi-cloud strategies](#private-cloud-hybrid-cloud-and-multi-cloud-strategies)
      - [So what is a Hybrid or Multicloud Strategy used for?](#so-what-is-a-hybrid-or-multicloud-strategy-used-for)
    - [How a network supports digital transformation](#how-a-network-supports-digital-transformation)
    - [Network Performance: Bandwidth + Latency](#network-performance-bandwidth--latency)
      - [Bandwidth](#bandwidth)
      - [Latency](#latency)
    - [Google Cloud regions and zones](#google-cloud-regions-and-zones)
    - [Google's Edge Network](#googles-edge-network)
    - [Quiz](#quiz-1)
  - [Cloud Computing Models and Shared Responsibility](#cloud-computing-models-and-shared-responsibility)
    - [Introduction to cloud computing models and shared responsibility](#introduction-to-cloud-computing-models-and-shared-responsibility)
    - [Cloud computing service models](#cloud-computing-service-models)
    - [IaaS (Infrastructure as a service)](#iaas-infrastructure-as-a-service)
      - [Benefits of IaaS](#benefits-of-iaas)
      - [Scenarios suitable for IaaS](#scenarios-suitable-for-iaas)
    - [PaaS (Platform as a service)](#paas-platform-as-a-service)
      - [Benefits of PaaS](#benefits-of-paas)
      - [Scenarios suitable for PaaS](#scenarios-suitable-for-paas)
    - [SaaS (Software as a service)](#saas-software-as-a-service)
      - [Benefits of SaaS](#benefits-of-saas)
      - [Scenarios suitable for SaaS be good for?](#scenarios-suitable-for-saas-be-good-for)
    - [Choosing a Cloud Computing Model](#choosing-a-cloud-computing-model)
    - [Shared Responsibility Model](#shared-responsibility-model)
    - [How the Shared Responsibility Model Works](#how-the-shared-responsibility-model-works)
    - [Quiz](#quiz-2)
- [2 - Exploring Data Transformation with Google Cloud](#2---exploring-data-transformation-with-google-cloud)
  - [The Value of Data](#the-value-of-data)
    - [How Data Creates Value](#how-data-creates-value)
    - [Unlocking business value from data](#unlocking-business-value-from-data)
    - [Data Management Concepts](#data-management-concepts)
      - [Database](#database)
        - [Relational Database](#relational-database)
        - [Non-Relational Database == NoSQL Database](#non-relational-database--nosql-database)
      - [Data Warehouse](#data-warehouse)
      - [Data Lake](#data-lake)
    - [Role of Data in Digital Transformation](#role-of-data-in-digital-transformation)
    - [Data Value Chain](#data-value-chain)
    - [Data Governance](#data-governance)
      - [Benefits of Data Governance](#benefits-of-data-governance)
    - [Quiz](#quiz-3)
  - [Google Cloud Data Management Solutions](#google-cloud-data-management-solutions)
    - [Unstructured data storage](#unstructured-data-storage)
      - [Cloud Storage](#cloud-storage)
        - [Benefits of Cloud Storage](#benefits-of-cloud-storage)
    - [Structured Data Storage](#structured-data-storage)
      - [Cloud SQL](#cloud-sql)
        - [Benefits of Cloud SQL](#benefits-of-cloud-sql)
      - [Cloud Spanner](#cloud-spanner)
      - [Cloud SQL vs Cloud Spanner](#cloud-sql-vs-cloud-spanner)
      - [BigQuery](#bigquery)
    - [Semi Structured Data](#semi-structured-data)
    - [Choosing the right storage product](#choosing-the-right-storage-product)
    - [Database Migration](#database-migration)
      - [Method 1 - Lift and Shift Platform Migration](#method-1---lift-and-shift-platform-migration)
      - [Method 2 - Managed Database Migration](#method-2---managed-database-migration)
    - [Quiz](#quiz-4)
  - [Making Data Useful + Accessible](#making-data-useful--accessible)
    - [Business intelligence and insights using Looker](#business-intelligence-and-insights-using-looker)
    - [Streaming Analytics](#streaming-analytics)
    - [PubSub + Dataflow](#pubsub--dataflow)
    - [Quiz](#quiz-5)
- [3 - Innovating with Google Cloud Artificial Intelligence](#3---innovating-with-google-cloud-artificial-intelligence)
  - [AI + ML Fundamentals](#ai--ml-fundamentals)
    - [Defining AI + ML](#defining-ai--ml)
    - [How AI + ML differ from data analytics + business intelligence](#how-ai--ml-differ-from-data-analytics--business-intelligence)
    - [Problems that ML is suited to solve](#problems-that-ml-is-suited-to-solve)
    - [Why ML required high-quality data](#why-ml-required-high-quality-data)
    - [Responsible and Explainable QI](#responsible-and-explainable-qi)
    - [Quiz](#quiz-6)
  - [Google Cloud's AI and ML Solutions](#google-clouds-ai-and-ml-solutions)
    - [BigQuery ML](#bigquery-ml)
    - [Pre-trained APIs](#pre-trained-apis)
    - [AutoML](#automl)
    - [Custom Models](#custom-models)
    - [TensorFlow](#tensorflow)
    - [AI Solutions (GCP Products)](#ai-solutions-gcp-products)
    - [Considerations when selecting Google Cloud AI/ML solutions](#considerations-when-selecting-google-cloud-aiml-solutions)
    - [Quiz](#quiz-7)
- [4 - Modernize Infrastructure and Applications with Google Cloud](#4---modernize-infrastructure-and-applications-with-google-cloud)
  - [Important cloud migration terminology](#important-cloud-migration-terminology)
  - [Modernising Infrastructure in the Cloud](#modernising-infrastructure-in-the-cloud)
    - [Benefits of running compute workloads in the cloud](#benefits-of-running-compute-workloads-in-the-cloud)
    - [Virtual Machines](#virtual-machines)
    - [Containers](#containers)
    - [Managing Containers = Kubernetes](#managing-containers--kubernetes)
    - [Serverless Computing](#serverless-computing)
    - [Quiz](#quiz-8)
  - [Modernising Applications in the Cloud](#modernising-applications-in-the-cloud)
    - [Benefits of Modern Cloud Application Development](#benefits-of-modern-cloud-application-development)
    - [Rehosting Legacy Applications in the Cloud](#rehosting-legacy-applications-in-the-cloud)
    - [APIs (Application Programming Interfaces)](#apis-application-programming-interfaces)
    - [Apigee API Management](#apigee-api-management)
    - [Hybrid + Multicloud](#hybrid--multicloud)

# Links

https://macquarie.udemy.com/organization/home/

https://www.coursera.org/programs/technology-domain-courses-scaxh?authProvider=macquariebank

https://learn.acloud.guru/course/google-cloud-digital-leader/dashboard

https://learn.acloud.guru/course/1ab914a9-23d2-4776-9862-e2ab3cd24807/dashboard

https://www.coursera.org/programs/technology-domain-courses-scaxh/professional-certificates/google-cloud-digital-leader-training?authProvider=macquariebank

# 1 - Digital Transformation with Google Cloud (GCP)

- **IaaS = Infrastructure as a Service**
- **PaaS = Platform as a Service**
- **SaaS = Software as a Service**

## Why Cloud Technology is Transforming Business

### Innovations, paradigm shifts, and digital transformation

- Paradigm Shift = A fundamental and irreversible change in the way that humans work and engage with the world
  - Current paradigm shift = Digital Transformation
- **Digital Transformation = When an organization uses _new digital technologies_, such as public, private, and hybrid Cloud platforms _to create or modify_ business processes, culture, and customer experiences _to meet_ the needs of changing business and market dynamics**
- Organizations choose digital transformation frameworks to:
  - Foster innovation
  - Generate new revenue streams
  - Adapt quickly to market changes and customer needs
- The IDC FutureScape report predicts
  - Over 50 percent of all IT spending will go to all digital transformation and innovation by 2024
  - By 2025, more than 90 percent of new enterprise Apps will have AI embedded within them

### What is the Cloud

- **Cloud = A metaphor for the network of data centers (software, servers, computers, networks) which store and compute information that's available through the Internet**

### IT Infrastructure implementations

#### On-premises (on-prem)

- **On-premises = On-Prem = Refers to hardware and software applications that are hosted on-site, located, and operated within an organization's data center to serve their unique needs**
- The benefits of on-premises is that it doesn't require third-party access, which gives owners physical control over the server hardware and software, and doesn't require them to pay for ongoing excess
- However, to have the computing power to run their required workloads, organizations must buy physical servers and other infrastructure through procurement processes that can take months
- These systems require physical space, typically a specialized room with sufficient power and cooling. After configuring and deploying the systems, businesses then need expert personnel to manage them
- This long process is difficult to scale when demand spikes or business expands. Organizations often acquire more computing resources than they actually need, which results in low utilization and high overhead

#### Private Cloud

- **A Private Cloud = Single Tenant = Corporate Cloud = A type of Cloud computing where the infrastructure is dedicated to a single organization instead of the general public**
- Typically, an organization has to perform the same ongoing maintenance and management for a private Cloud as it would for traditional on-premises infrastructure
- A private Cloud is hosted within an organization's own private servers, either at organization's own datacenter, at a third-party co-location facility or by using a private Cloud provider
- Private Cloud computing gives businesses many of the benefits of a public Cloud, including self-service, scalability, and elasticity, with more customization available from dedicated on-premises infrastructure
- Organizations might use private Cloud if they have already made significant investments in their own infrastructure, or if for regulatory reasons, data must be kept on-premises or hosted in a certain way

#### Public Cloud

- **The Public Cloud = Multi-Tenant Cloud Infrastructure = A type of cloud where on-demand computing services and infrastructure are managed by a third party provider, such as Google Cloud, and shared with multiple organizations or tenants through the public Internet**
- But each tenant's data and applications running in the Cloud are hidden from other tenants. - You can think of it like an apartment building that's maintained by a property management company
  - The building has many units and tenants
  - Each unit might have a slightly different layout, but still has all the amenities a tenant needs to live there, and each unit is locked and private to the tenant who pays for that space
- Public Cloud is what is referred to when we say "cloud"
- Because public Cloud has an on-demand availability of computing and infrastructure resources, organizations don't need to acquire, configure, or manage those resources themselves, and they only pay for what they use
- There are typically three types of Cloud computing service models available in public Cloud
  - The first is infrastructure as a service **IaaS = Offers compute and storage services**
  - The second is Platform as a Service **PaaS = Offers a develop and deploy environment to build Cloud apps**
  - The third is Software as a Service **SaaS = Delivers apps and services where users get access to software on a subscription basis**

#### Hybrid Cloud

- **Hybrid Cloud = Type of Cloud where applications run in a combination of different environments**
- The most common hybrid Cloud example is combining a public and private Cloud environment like an on-premises datacenter and a public Cloud computing environment like Google Cloud

#### Multi-Cloud

- **Multi-Cloud = Describes architectures that combine at least two public Cloud providers**
- Organizations might operate a combination of on-premises and multiple public Cloud environments, therefore, implementing both hybrid and multi-Cloud simultaneously
- Today, most organizations embrace a multi-Cloud strategy
- According to the Flexera, 2022, states of the Cloud report, 89 percent of respondents reported having a multi-Cloud strategy, and 80 percent of them take a hybrid approach by combining public and private Cloud

### Benefits of cloud computing

- **Scalable**
  - Cloud computing gives organizations access to scalable resources and the latest technologies on-demand, so they don't need to worry about capital expenditures or limited fixed infrastructure
  - This can significantly accelerate infrastructure deployment time
- **Flexible**
  - Organizations and their users can access Cloud services from anywhere with an Internet connection, scaling services up or down as needed to meet business requirements
- **Agile**
  - Organizations can develop new applications and rapidly get them into production without worrying about the underlying infrastructure
- **Strategic value offered**
  - Because Cloud providers stay updated with the latest innovations and offer them as services to customers, organizations can get more competitive advantages and a higher return on investment than if they'd invested in soon to be obsolete technologies
  - This lets organizations innovate and try new ideas faster
- **Secure**
  - Cloud computing security is recognized as stronger than that in enterprise data centers because of the depth and breadth of the security mechanisms and dedicated teams that Cloud providers implement
- **Cost-Effective**
  - No matter which Cloud computing service model organizations implement, they only pay for the computing resources they use
  - They don't need to overbuild datacenter capacity to handle sudden spikes in demand or business growth, and they can deploy IT staff to work on more strategic initiatives

### Real-world examples: Why it's critical to transform and embrace new technology

- **Focus on why they exist and NOT how they operate**

### Cloud eras

- Starts with **VM Cloud Era**
  - VM = Virtual Machine
  - New organizations/startups, realized that they could forgo ever buying or operating hardware and just start in the Cloud
  - This was a major catalyst for many of the great Cloud native companies that we rely on today, such as Twitter, Spotify, and PayPal
  - By the end of this first VM Cloud Era, very few startups operated their own datacenters
- Next is **Infrastructure Cloud Era**, which is when organizations migrated their IT infrastructure to the Cloud
  - This migration saved costs because infrastructure could scale up and down more quickly and easily
  - Faster development was possible because companies didn't need long-term infrastructure planning and security was better
  - Also, reducing the management load on IT staff, let organizations direct more people and resources to focus on building new capabilities
- Reinventing the future means changing not only where business is done, but how it is done
  - It requires maximizing the benefits of the Cloud and building an environment that enables every person, process and technology to bring the highest level of innovation to the business
  - **Transformation Cloud Era**, where organizations are not just making infrastructure decisions, but to truly focusing on transforming
- A transformation Cloud is a new approach to digital transformation
  - It provides an environment for app and infrastructure modernization, data democratization, people connections, and trusted transactions
  - It's built on an easy-to-use platform with customized industry solutions that gives organizations the confidence, they're saving money and creating a more sustainable future for everyone
  - The result is an organization that benefits from Cloud computing to drive innovation, generate new revenue streams, and adapt quickly to market changes and customer needs

### Challenges that lead to a digital transformation

1. **They want to be the best at understanding, and using data**
   - Today, organizations must unify data across streams, lakes, warehouses, and databases, so that they can quickly, and easily break down data silos, generate real-time insights, and make better business decisions, thus reducing cost, and inefficiencies
2. **They want the best technology infrastructure**
   - Organizations are looking for a Cloud platform that will serve as their foundation for growth, and has the flexibility to innovate securely, and adapt quickly based on market needs
3. **They want to create the best hybrid workplace**
   - The fundamental shift in how, and where we work requires new, stronger connections, and collaboration
   - Many interactions that took place in person have been digitized. This change requires more intentional connections, and collaboration
4. **It's critical for organizations to know that their data systems, and users are secure**
   - The digital world is seeing more severe security issues, so now companies are rethinking their security posture
   - They must find ways to identify, and protect everything from people, and customers for data, and transactions in a fast changing environment
   - prioritizing sustainability as a critical board level topic
     - They want to create a more sustainable future through products, and services that minimize environmental impact

### Google's Transformation Cloud

#### Data

- Data is the key to unlocking value from AI, making it critical for innovation and differentiation
- According to the new Vantage Partners Data and AI Executive Survey 2022. Only 26.5% of companies have succeeded in creating a data-driven organization to realize tangible and measurable value from their data
- A **data cloud = a unified solution to manage data across the entire data life cycle regardless of whether it sits in Google Cloud or in other clouds**
  - It lets organizations identify and process data with great scale, speed, security and reliability

#### Open Infrastructure

- Companies choose to modernise their IT systems on open infrastructure cloud because it gives them freedom to securely innovate and scale from on premises to edge to cloud on an easy transformative and open platform
- Open infrastructure cloud brings Google Cloud services to different physical locations while leaving the operation governance and evolution of the services to Google Cloud
- Most organizations want the freedom to run applications in the place. That makes the most sense using hybrid and multicloud approaches based on open source software
- An open infrastructure cloud facilitates fast innovation and reduces lock into a single cloud provider
  - By giving organizations a choice and flexibility to build, migrate and manager applications across on premises and multiple clouds
- _Open Standard vs Open Source_
  - **Open Standard = Software that follows particular specifications that are openly accessible and usable by anyone**
    - They have guidelines for software functionality, which help avoid vendor lock in and ensure that the products that use these standards are forming an interoperable way. Examples of open standards are HTTP for requesting content on the web, or XML for storing structured data
  - **Open Source = Software whose source code is publicly accessible and free for anyone to use, modify and share**
    - A decentralized community generally develops open source software as a public collaboration based on the philosophy of transparency and the open exchange of ideas
- Google's open source projects (GCP Product)
  - Kubernetes
  - TensorFlow
  - Hybrid and multi cloud environments managed by products like Anthros (built upon Kubernetes, Istio and Knative)
- An open infrastructure embraces a partner ecosystem and the breadth of solutions it can offer its customers instead of competing with it
- Collaboration Cloud = Google Workspace
- A trusted cloud helps organizations protect what's important with advanced security tools
- According to cybersecurity ventures, the annual cost of Cybercrime is expected to reach $10.5 trillion annually by 2025
- According to IDC cloud computing is estimated to save 1 billion metric tons of CO2 emissions by 2024

### Google Cloud Adoption Framework

- 3 things **People + Process + Technology**
- **Google Cloud Adoption Framework = Short term tactical, midterm strategic, and long term transformational business objectives**
- A cloud maturity assessment helps to establish where an organization is currently regarding the cloud adoption themes recognized by Google Cloud
  - It can quickly reveal any areas where an organization might be weaker or under invested

### Quiz

Q1 - Select the definition of digital transformation

- When an organization uses new digital technologies to create or modify on-premises business processes
- When an organization uses new digital technologies to create or modify technology infrastructure to focus on cost saving
- **When an organization uses new digital technologies to create or modify business processes, culture, and customer experiences**
- When an organization uses new digital technologies to create or modify financial models for how a business is run

Q2 - What is the cloud?

- **A metaphor for a network of data centers**
- A metaphor for the networking capability of internet providers
- A Google product for computing large amounts of data
- A Google product made up of on-premises IT infrastructure

Q3 - What is seen as a limitation of on-premises infrastructure, when compared to cloud infrastructure?

- **The on-premises hardware procurement process can take a long time**
- Maintenance workers do not have physical access to the servers
- Scaling processing is too difficult due to power consumption
- The on-premises networking is more complicated

Q4 - An organization has a new application, and user subscriptions are growing faster than on-premises infrastructure can handle. What benefit of the cloud might help them in this situation?

- It provides physical access, so the organization can deploy servers faster
- It's cost effective, so the organization will no longer have to pay for computing once the app is in the cloud
- **It's scalable, so the organization could shorten their infrastructure deployment time**
- It's secure, so the organization won't have to worry about the new subscribers data

Q5 - An organization has made significant investments in their own infrastructure and has regulatory requirements for their data to be hosted on-premises. Which cloud implementation would best suit their needs?

- **Private Cloud**
- Public Cloud
- Platform as a service
- Software as a service

Q6 - What is the benefit of implementing a transformation cloud that is based on open infrastructure?

- On-premises software isn't open source, so cloud applications are more portable
- Open source software makes it easier to patent proprietary software
- Open standards make it easier to hire more developers
- **Open source software reduces the chance of vendor lock-in**

Q7 - As the world and business changes, organizations have to decide between embracing new technology and transforming, or keeping their technology and approaches the same. What risks might an organization face by not transforming as their market evolves?

- Organizations risk losing market leadership if they spend too much time on digital transformation
- Embracing new technology can cause organizations to overspend on innovation
- **Focusing on 'how' they operate can prevent organizations from seeing transformation opportunities**
- Focusing on 'why' they operate can lead to inefficient use of resources and disruption

Q8 - Which item describes a goal of an organization seeking digital transformation?

- **Break down data silos and generate real time insights**
- Ensure better security by decoupling teams and their data
- Streamline their hardware procurement process to forecast at least a quarter into the future
- Reduce emissions by using faster networks in their on-premises workloads

Q9 - Select the two capabilities that form the basis of a transformation cloud? Select two correct answers

- **Data cloud provides a unified solution to manage data across the entire data lifecycle**
- Collaboration cloud ensures that the device a user connects with only works on the corporate network
- **Open infrastructure gives the freedom to innovate by running applications in the place that makes the most sense**
- Sustainable cloud ensures the costs of cloud resources are controlled to prevent budget overrun
- A trusted cloud gives control of all resources to the user to ensure high availability at all times

## Fundamental Cloud Concepts

### Total Cost of Ownership (TCO)

- **TCO = Total Cost Of Ownership Analysis = Aims to weigh the cost of cloud adoption against the cost of running their current on-premises systems**
- For on-premises TCO is associated with assessing the cost of static resources throughout their lifetime
- However, due to the dynamic nature of the cloud, predicting future costs can be challenging
  - A common mistake that organizations make when attempting to calculate cloud TCO, is to directly compare the running costs of the cloud against their on-premises system
  - These costs are NOT equivalent
  - The cost of on-premises infrastructure is dominated by the initial purchase of hardware and software, but cloud computing costs are based on monthly subscriptions or pay per use models
  - It's also important to consider all of the operational costs of running your own data center, such as power, cooling, maintenance and other support services
- A data center is a building or facility that houses a large amount of IT infrastructure, computing and storage resources in one place
- Intangible costs such as the opportunity cost of not migrating to cloud, in the miss benefits should be considered

### Capital Expenditures (CapEx) vs Operating Expenses (OpEx)

- **CapEx == Capital Expenditure == Upfront Business Expenses Put Toward Fixed Assets**
  - Organizations buy these items once and they benefit their business for many years
  - For example in IT, these expenditures might mean buying hardware like servers, printers, or cooling systems
  - Maintaining these assets is also considered CapEx because it extends their lifetime and usefulness
  - Small businesses can find CapEx Spending challenging because large onetime purchases are often high cost
  - The more money you put towards CapEx means less free cashflow for the rest of the business
- **OpEx == Operating Expenses == Recurring costs for a more immediate benefit**
  - This represents the day-to-day expenses to run a business
  - These expenses might be yearly services like website hosting or domain registrations, or the subscription fee for Cloud services
  - OpEx covers the spending on pay as you go items, but are not considered major long-term investments like CapEx items
- In the on-premises CapEx model, cost management and budgeting are onetime operational process completed annually
  - Data centers require a huge CapEx investment upfront as organizations purchase space, equipment, and software and higher workforce to run and maintain everything
  - Forecasting is based on a metric such as historic growth to determine the needs of the next month, quarter, year or even multiple years
- Moving to Cloud's on-demand OpEx model enables organizations to pay only for what they use and only when they use it
  - Budgeting is no longer a one-time operational process completed annually
  - Instead, spending must be monitored and controlled on an ongoing basis due to the dynamic nature of Cloud use within organizations
- A more decentralized Cloud world, any employee can create resources and seconds on infrastructure owned and managed by a Cloud provider
  - Organizations save on power, cooling, and floor space
  - They save on management because they don't have to install, operate, upgrade, and troubleshoot it themselves and they're not depreciating the equipment

### Private cloud, hybrid cloud, and multi-cloud strategies

- It's not always possible or necessary for an organization to rely solely on the cloud
  - For example, requirements might call for on-premises infrastructure to work with public cloud services provided by companies like Google cloud
- **Private Cloud = When an organization has virtualized servers in its own data centers, or those of a private cloud provider to create its own private dedicated environment**
  - On-premises servers are also often referred to as private clouds, but generally, the distinction can be made that on-premises software runs in a local environment, whereas a private cloud is accessed through the Internet
  - Private cloud computing gives an organization many of the benefits of a public cloud, including self service, scalability, and elasticity
  - With more customization available than from dedicated on-premises infrastructure
  - This approach is often used when an organization has already made significant infrastructure investments, or if for regulatory reasons, data must be kept on-premises
  - See "hosted private cloud"
- **Hybrid Cloud == when applications are running in a combination of different environments (i.e. private + public cloud environment)**
  - The most common example is combining a private and public cloud environment, like an on-premises data center in a public cloud computing environment like Google Cloud
- **Multi-cloud**, which describes architectures that combine at least two public cloud providers such as Google Cloud, Amazon web services, Microsoft Azure, or others
- An organization might choose multicloud if they want to take advantage of the key strengths of different public cloud providers
  - Organizations might also operate a combination of on-premises and multiple public cloud environments, effectively being both hybrid and multicloud simultaneously
  - A hybrid cloud approach is one of the most common infrastructure setups today, because organizations can continue to use their on-premises servers while also taking advantage of public cloud

#### So what is a Hybrid or Multicloud Strategy used for?

- **Access to the latest technologies**
  - Running workloads in multiple clouds empowers organizations to leverage the latest innovations and capabilities from each cloud provider. Thus taking a best-in-class approach to cloud features and obtaining the scale, security, and agility to innovate fast
- **Modernize at the right pace**
  - With a hybrid cloud organizations can migrate applications to the cloud at the pace that makes sense for their business, and transform their technical infrastructure over time
- **Improved return on investment**
  - By adding a public cloud provider to their existing on-premises infrastructure, organizations can expand their cloud computing capacity without increasing their data center expenses
  - This can help reduce CapEx or general IT spending, and improve transparency regarding costs and resource consumption
- **Flexibility through choice of tools**
  - Hybrid and multicloud strategies have advantages for organizations as a whole, but specifically benefit development teams that are working on different projects and tackling unique challenges across different lines of business
  - A wider choice of tools and developer talent can be applied to a particular business problem, which means responding better to changing market demands
  - It also avoids vendor lock-in concerns
- **Improve reliability and resiliency**
  - Organizations can distribute core workloads across multiple cloud and on-premises infrastructures to reduce downtime and concerns about overdependence on a single source of failure
- **Maintain regulatory compliance**
  - Many industries have rules from governmental or regulatory bodies regarding where their app can operate
  - Adopting a hybrid solution is an effective way for an organization to ensure compliance with regional data governance, residency, and digital sovereignty requirements
- **Running apps on-premises**
  - Organizations may have regulated applications that must remain on-premises, or mainframe systems that are difficult to move to the cloud
  - A hybrid approach provides the freedom to innovate while still meeting legacy technology needs
- **Running apps at remote edge locations**
  - Organizations and industries that run distributed apps at remote locations such as kiosks and retail or networks and telecom, can benefit from hybrid cloud
  - These apps often require improved performance and low latency, and a hybrid approach lets them run select apps at the network edge

### How a network supports digital transformation

- A fast reliable and low latency global network insures exceptional user experience and high performance
  - It also makes it easier to communicate and manage data globally with ever more distributed workforces and online businesses having virtual network services that can easily scale without adding hardware ensures that organizations can adapt
- **Fiber Optic Networks = Foundation of the modern Internet**
  - Fiber optic cables contain one or more optical fibers which are thin strands made of glass or plastic, these fibers are used to transmit data as pulses of light over long distances
- The first sub-sea cable was deployed in 1858 for telegraph messages between Europe and North America
  - Today a single cable can deliver a whopping 340 terabits per second
  - Every shared video sent e-mail and downloaded app depends on data traffic that moves through international network infrastructure
- But how is this content available to people within milliseconds?
  - A rich ecosystem of companies and local providers build a global infrastructure that provides businesses and people around the world with the best possible Internet experience
  - These include companies like ISP = Internet Service Providers
  - ISPs provide access to the Internet to both personal and business customers handling the traffic between the customer and the internet as a whole
  - Some examples of ISPs include Verizon, Vodafone, and SoftBank
- The infrastructure that makes Google's global reach possible is our network of fiber optic cables that run on both land and sea
  - Google owns and operates data centers all over the world in these Google datacenters products like Search, G-mail, Youtube, and Google Cloud
- **IP Address = Internet Protocol Address**
  - The IP stands for Internet Protocol in this address is a series of numbers that can identify and network or the location of a particular device on a network
- **Domain Name = An easy to remember name that maps directly to an IP address or set of IP addresses on the internet**
  - It's the unique name that appears after the at sign in email addresses and after www. in web addresses
  - For instance the domain name example.com might translate to the IP address 192.168.200.8
  - Other examples of domain names are google.com and YouTube.com
- **DNS = Domain Name System**
  - The DNS server stores a database of domain names mapped to IP addresses that can be queried and used by computers to communicate with each other
  - This system is like the phone-book of the web
  - Every time you visit a website your computer performs a DNS lookup
  - A phone book translates a name like acme pizza into the correct phone number to call
  - Similarly the DNS translates a web address like www.google.com into the IP address of the computer hosting that site

### Network Performance: Bandwidth + Latency

#### Bandwidth

- **Bandwidth = Measure of how much data a network can transfer in a given amount of time**
  - This rate of data transfer measured in terms of megabits per second or Mbps or gigabits per second or Gbps
  - Higher bandwidth = more data download
  - Analogy = water flowing through a pipe
    - The bandwidth would be the volume of water a pipe can handle flowing through per second
  - An Internet service provider may provide a home internet connection with 100 megabits per second to over one gigabit per second
  - A datacenter may have lines with bandwidth from 10-100 gigabits per second

#### Latency

- **Network Latency = The amount of time it takes for data (packet of information) to travel from its source to destination**
  - Measured in milliseconds, latency (lag) describes delays in communication over a network
  - Lower latency/lag = faster response time
  - Analogy = the delay from the moment the water pipe is opened until water starts flowing through
  - Ideally, latency should be as close to zero as possible
    - However, because it's a result of the physical distance that data must travel through wires, fiber optics, routers, and more, to reach its destination each hop along the way adds a small amount of latency to the communication
    - No matter how much data you send and receive at once it can only travel as fast as network latency allows
  - Websites run slower for some users depending on their physical location even if both the user and the server have excellent bandwidth
    - The further/farther a user is from a server or the more fragmented the network is, the bigger the latency
    - Reducing latency is essential to reaching users faster
  - Matters more for real-time multiplayer games

### Google Cloud regions and zones

- **Aim = Highest possible throughput + Lowest possible latency**
- Google Cloud's Infrastructure is based in five major geographic locations
  - **North America**
  - **South America**
  - **Europe**
  - **Asia**
  - **Australia**
- Having multiple service locations is important because choosing where to locate applications affects qualities like availability, durability and latency
  - The latency of which measures the time a packet of information takes to travel from its source to its destination
- Each of these locations is divided into several different regions and zones
  - **Region = Regions = Independent geographic areas that are composed of zones**
    - For example, London or Europe-west2 is a region that currently comprises three different zones
  - **Zone = Zones = A zone is an area where Google cloud resources are deployed**
    - For example, if you launch a virtual machine using compute engine, it will run in the zone that you specify to ensure resource redundancy
- You can also run resources in different regions
  - This is useful for bringing applications closer to users around the world and also for protection in case there are issues with an entire region such as a natural disaster
- Some of Google cloud services support placing resources in what we call a multi-region
  - For example, cloud storage lets you place data within the Europe multi-region
  - This means it's stored redundantly in at least two geographic locations separated by at least 160 km within Europe like London and Belgium
  - You can find the most up to date numbers for Google cloud regions and zones at cloud.google.com/about/locations

### Google's Edge Network

- A recommended best practice for organizations is to keep their traffic and Google's private network for most of its journey
  - Using the same network that powers products like Gmail, Google Search, and YouTube allows organizations to take advantage of the performance that global infrastructure provides
- When a user opens a Google app or webpage, Google response to that request from an edge network location that will provide the lowest latency
- Understanding Google's edge network and how it maintains caches that store popular content near its users, helps organizations choose when to handoff traffic to Google
- **Network Edge = A place where a device or an organization's network connects to the Internet**
  - It's called the **edge because it's the entry point to the network**
- Google's edge network is how it connect with ISPs to get traffic to and from users
  - It's made up of network infrastructure that organizations can hand off traffic to based on user's needs, performance, and cost
  - Google aims to deliver its services with high-performance, high reliability, and low latency for users

### Quiz

Q1 - A financial services organization has bank branches in a number of countries, and has built an application that needs to run in different configurations based on the local regulations of each country. How can cloud infrastructure help achieve this goal?

- Total cost of ownership of the infrastructure
- Reliability of the infrastructure availability
- **Flexibility of infrastructure configuration**
- Scalability of infrastructure to needs

Q2 - An organization has shifted from a CapEx to OpEx based spending model. Which of these statements is true?

- Hardware procurement is done by a centralized team
- **They will only pay for what they use**
- Budgeting will only happen on an annual basis
- They will only pay for what they forecast

Q3 - An organization wants to innovate using the latest technologies, but also has compliance needs that specify data must be stored in specific locations. Which cloud approach would best suit their needs?

- On-premises infrastructure
- Public Cloud
- Multicloud
- **Hybrid Cloud**

Q4 - Which network performance metric describes the amount of data a network can transfer in a given amount of time?

- Fiber optics
- Latency
- Domain Name System (DNS)
- **Bandwidth**

Q5 - An organization wants to ensure they have redundancy of their resources so their application remains available in the event of a disaster. How can they ensure this happens?

Using the edge network to cache the whole application image in a backup
By putting resources in the Domain Name System (DNS)
**By putting resources in different zones**
By assigning a different IP address to each resource

## Cloud Computing Models and Shared Responsibility

### Introduction to cloud computing models and shared responsibility

- When moving to the cloud, there are decisions to make about how to manage and operate different cloud services
  - One of those decisions is around the type of cloud computing service model to use
    - IaaS
    - PaaS
    - SaaS
  - Organizations typically choose service model types based on their specific business requirements

### Cloud computing service models

- **Cloud Computing Models = IaaS, PaaS, and SaaS = Different cloud computing models provided as a service by Cloud providers**
  - As a service = The way IT resources are consumed in these models, and is a key difference between cloud computing and traditional IT
  - Infrastructure as a service IaaS = which offers infrastructure resources such as compute and storage,
  - Platform as a service PaaS = which offers a develop and deploy environment to build cloud apps
  - Software as a Service SaaS = which delivers complete applications or services
- Each model offers distinct features and functionalities, and knowing the difference between them helps organizations choose one to best fit their businesses needs
  - It's important to remember that most organizations that use Cloud often use a combination of cloud computing models to solve for different needs
- In traditional IT, an organization consumes resources, such as hardware, software, and development tools by purchasing, installing, managing, and maintaining them in its own on-premises or self-managed data center
  - Organizations are responsible for all of their IT infrastructure when it's completely on-premises
- In cloud computing, the Cloud service provider owns, manages, and maintains the resources
  - The customer consumes those resources, which are provided on a subscription or pay-as-you-go basis
  - All you need is an Internet connection
  - Cloud computing allows for a third party to be responsible for some part of the infrastructure
  - This means that organizations then have more time to focus on their core business
- Pyramid:
  - SaaS
  - PaaS
  - IaaS
- As you move up the layers from one model to another, each model requires less knowledge and management of the underlying infrastructure known as abstraction
  - In Cloud architecture, as the level of abstraction increases, less is known about the underlying implementation
  - The goal of abstracting away infrastructure is to reduce complexity by removing unnecessary information and simplifying operations
- Abstraction is one of the core features of cloud computing
  - When choosing between cloud computing service models, organizations must decide the level of control and management they'll require, or how much they want to hide technical details and focus on business needs
- Transport/Car analogy
  - _On-prem == on premises IT infrastructure == owning a car_
    - When you buy a car, you're responsible for its usage and maintenance
    - Upgrading means buying a new car, which takes time and can be costly
  - _IaaS == leasing a car_
    - When you lease a car, you choose a car and drive it wherever you want, but the car isn't yours
    - Upgrading is easier though, as you can just lease a new car
  - _PaaS == taking a taxi_
    - You provide specific directions like the code, but the driver does the actual driving
  - _SaaS == like going by bus_
    - You still get access to transport, but it's less customizable. Buses have designated routes and you share the space with other passengers

### IaaS (Infrastructure as a service)

- **IaaS = A computing model that offers the on demand availability of almost infinitely scalable infrastructure resources such as compute, networking, storage and databases as services over the Internet**
  - IaaS allows organizations to _lease the resources they need_, instead of having to buy hardware outright and _they only pay for what they use_
  - It _provides the same technologies and capabilities_ as a traditional data center without having to physically _maintain_ or _manage_ all of it
- One of the main reasons businesses chooses IaaS to reduce their capital expenditures and transform them into operational expenses
- **Downsides of Traditional IT**
  - _Procurement process (time + cost)_
    - Procurement takes many months/years
  - _Physical spaces (power + cooling)_
  - _IT professionals needed to maintain_
  - _Challenging to scale (when demand spikes or business grows)_
    - Risk running out of capacity or over building and ending up with underutilized infrastructure
- In contrast, IaaS resources are offered as individual services, so organizations can choose what they need
  - The cloud provider manages the infrastructure, and businesses can concentrate on installing, configuring and managing software and keeping their data secure
  - "Compute Engine" and "Cloud Storage" are examples of GCP IaaS products (GCP Product)
    - Compute Engine:
      - Create and run virtual machine
    - Cloud storage:
      - Store any type of data

#### Benefits of IaaS

- It's **economical**
  - Resources are used on demand and you only pay for what you use?
  - IaaS ask costs are fairly predictable and easy to budget for
- It's **sufficient**
  - IaaS resources are regularly available when you need them
  - As a result, there are fewer delays when infrastructure is expanded and resources aren't wasted by over building capacity
  - This efficiency leads to faster development life cycles and ultimately a faster time to market
- It **boosts productivity**
  - The cloud provider is responsible for setting up and maintaining the physical infrastructure
  - IT departments can save time and money
  - They can then redirect resources to more strategic activities
- It's **reliable**
  - IaaS has no single point of failure
  - Even if one component of the hardware resources fails, the service usually remains available
- It's **scalable**
  - One of the biggest advantages of IaaS in cloud computing is the capability to scale the resources up and down rapidly according to business needs

#### Scenarios suitable for IaaS

- The flexibility and scalability of IaaS useful for organizations that:
  - Have unpredictable workload volumes or need to move quickly in response to business fluctuations
  - Require more infrastructure scalability and agility than traditional data centers can provide
  - Have high business growth that outpaces infrastructure capabilities
  - Experience unpredictable spikes in demand for infrastructure services
  - See low utilization of existing infrastructure resources

### PaaS (Platform as a service)

- **Platform as a service or PaaS == a computing model that offers a cloud-based platform for developing, running, and managing applications**
- PaaS provides a framework for developers that they can build upon and use to create customized applications
- No need to build and maintain the associated infrastructure
- Can use builtin software components to build applications
- Reduces the amount of code written
- PaaS is appealing because it provides a platform for developers to develop, run, and manage their own apps without having to build and maintain the associated infrastructure
  - They can also use built-in software components to build their applications, which reduces the amount of code they have to write
- "Cloud Run "and "BigQuery" are examples of GCP PaaS products (GCP Product)
  - Cloud Run is a fully managed _serverless platform_ for _developing and hosting applications at scale_, which takes care of provisioning servers and scaling app instances based on demand
  - BigQuery is a fully managed _enterprise data warehouse_ that _manages and analyzes data_ and can be queried to answer big data questions with zero infrastructure management

#### Benefits of PaaS

- It **reduces development time**
  - Developers can go straight to coding instead of spending time, setting up and maintaining a development environment, which leads to faster time to market
- It's **scalable**
  - With PaaS, organizations can purchase additional capacity for building, testing, staging, and running applications whenever they need it
- It also allows for applications to be designed to take advantage of the inherent scalability of cloud infrastructure
- It **reduces management** by abstracting the management of underlying resources even further than on IaaS
  - PaaS offloads infrastructure management, patches, updates, and other administrative tasks to the cloud service provider
  - This provides a cost-effective way to focus on new functionality
- It's **flexible**
  - With support for different programming languages and easy collaboration for distributed teams, PaaS provides developers with the flexibility to deliver various projects from prototypes to enterprise solutions on the same platform

#### Scenarios suitable for PaaS

- PaaS is suitable for organizations that want to create unique and custom applications without investing a lot in owning and managing infrastructure
- Want to rapidly test and deploy applications. Have many legacy applications and want to reduce the cost of operations
- Have a new app project that they want to deploy quickly by growing and updating the app as fast as possible
- Want to only pay for resources while they're being used
- Want to offload time-consuming tasks, such as setting up and maintaining application servers and development and testing environments

### SaaS (Software as a service)

- **Software as a Service, or SaaS, is a computing model that offers an entire application managed by a cloud provider through a web browser**
- The cloud provider hosts the application software in the cloud and delivers it through a browser
  - With this model, you don't need to download or install any of it
- SaaS is appealing because it's abstracts technology completely from the consumer
  - The end-user doesn't need to care about the underlying infrastructure, which is the cloud provider's responsibility
  - Organizations simply pay a subscription fee for access to a ready to use software product
  - Google Workspace, which includes tools such as Gmail, Google Drive, Google Docs, and Google Meet, is a GCP SaaS product (GCP Product)
  - E.g. Slack

#### Benefits of SaaS

- It's **low maintenance**
  - SaaS eliminates the need to have IT staff download and installed applications on each individual computer
  - With SaaS, **vendors manage all potential technical issues** such as data, servers, storage, and updates in the cloud
  - This helps to streamline maintenance and support for an organization
- It's **cost-effective**
  - SaaS is based on a subscription model with a fixed, inclusive monthly or annual account fee
  - Predictable costs and per-user budgeting allows for clear financial governance
- It's **flexible**
  - Everything is available over the Internet, when a user signs into their personalized account online
  - They can access the software from anywhere, any device, anytime

#### Scenarios suitable for SaaS be good for?

- SaaS is suitable for organizations that:
  - Want to use standard software solutions that require minimal customization,
  - Do NOT want to invest time or internal expertise in maintaining applications or infrastructure,
  - Need more time for IT teams to focus on strategic projects
  - Need to access apps from various devices and locations

### Choosing a Cloud Computing Model

- **IaaS**
  - _If they're looking for a highly flexible scalable service while maintaining control of their infrastructure, then IS is the right choice_
  - This model offers the most control and customization, but also requires the most management responsibilities and technical expertise
- **PaaS**
  - _If they need a platform designed for building software products then PaaS would help that business immediately_
  - This provides a cost effective way to build applications that still require some technical expertise and less management
- **SaaS**
  - _If they want features that are ready to use without the hassle of installations then SaaS might be the best option_
  - This represents the least management responsibilities and technical expertise, but it also offers the least control and customization
- These computing models are not mutually exclusive though
- Depending on the use case, most organizations will use combinations of all three to solve for different business needs
  - They'll need to compare their options based on variables, such as management level, control, responsibility, flexibility, and expertise needed
  - For example, imagine a large organization needs to implement a new inventory management system
    - If they had the in-house expertise to develop it and the willingness to manage the infrastructure, they could build this with IS resources
    - The organization's IT team would have complete control over server configurations, but also bear the burden of managing and maintaining them
  - They could choose a PaaS solution and build a custom CRM application while offloading management of infrastructure to the cloud service provider, retaining complete control of application features, but reducing the management load
  - Finally, they could choose to buy a ready-made SaaS solution
    - Having no daily management of infrastructure, but also giving up all control over features and functionality in the software

### Shared Responsibility Model

- One area of responsibility where each of the Cloud computing models differ is security
- When an organization manages its data in its own data centers, that organization is responsible for all aspects of its security
  - **Shared Responsibility = When infrastructure is moved to the Cloud, some aspects of the responsibilities shift to the Cloud provider**
- Security in the Cloud is a shared responsibility between the Cloud provider and the customer
  - Although direct responsibility has changed based on the Cloud computing service model, organizations are always in control of securing their data and the Cloud provider is always responsible for securing the infrastructure
- At Google Cloud, we defend organization's data against threats and fraudulent activity with the same infrastructure and security services we use for our own operations
- **Security OF the Cloud != Security IN the Cloud**
  - _The Cloud provider is responsible for the security of the Cloud, while the customer is responsible for security in the Cloud_

### How the Shared Responsibility Model Works

- A general guideline for shared responsibility is that if you configure or store it, you're responsible for securing it
- This generally means that a Cloud provider is responsible for securing the parts of the Cloud that it directly controls such as hardware, networks, and physical security
- _The customer is responsible for securing anything that they create within the Cloud, such as the configurations, access policies, and user data_
- On-prem
  - When an organization runs its on-premises data-centers, security for the infrastructure is solely the responsibility of the organization's internal teams. They are responsible for securing servers and the data stored on them
- IaaS
  - When an organization transitions to an IaaS computing model, it's assigned some IT security responsibilities to Google Cloud
  - This includes being responsible for the physical resources and sharing responsibility with the customer for the security of the infrastructure and network
  - The rest, such as the security of the operating system, software stack required to run the applications, and their data is the responsibility of the customer
- PaaS
  - This includes full responsibility for the physical infrastructure, the access and authentication, network security, and guest operating systems
  - The customer is still responsible for the security of any content such as code or data produced on the platform
- SaaS
  - Google Cloud is responsible for almost every aspect of security, from the underlying infrastructure to the actual application
  - Customers still have some security responsibilities, such as application usage, access policies, like authentication settings to prevent phishing attacks, and the user content
- One important aspects of the shared responsibility model is that customers are always responsible for the security of their data
  - The customer controls who or what has access to their data

### Quiz

Q1 - Which cloud computing service model offers a develop-and-deploy environment to build cloud applications?

- Function as a Service (FaaS)
- Infrastructure as a Service (IaaS)
- Software as a Service (SaaS)
- **Platform as a Service (PaaS)**

Q2 - An organization wants to move their collaboration software to the cloud, but due to limited IT staff one of their main drivers is having low maintenance needs. Which cloud computing model would best suit their requirements?

- Infrastructure as a Service (IaaS)
- **Software as a Service (SaaS)**
- Platform as a Service (PaaS)
- IT as a service (ITaaS)

Q3 - Which option best describes a benefit of Infrastructure as a Service (IaaS)?

- It has low management overhead, as all administration and management tasks for data, servers, storage, and updates are handled by the cloud vendor
- It's cost-effective, as all infrastructure costs are handled under a single monthly or annual subscription fee
- **It's efficient, as IaaS resources are available when needed and resources aren't wasted by overbuilding capacity**
- It reduces development time, as developers can go straight to coding instead of spending time setting up and maintaining a development environment

Q4 - In the cloud computing shared responsibility model, what types of content are customers always responsible for, regardless of the computing model chosen?

- The customer is not responsible for any of the data in the cloud, as data management is the responsibility of the cloud provider who is hosting the data
- The customer is responsible for all infrastructure decisions, server configurations and database monitoring
- **The customer is responsible for securing anything that they create within the cloud, such as the configurations, access policies, and user data**
- The customer is responsible for security of the operating system, software stack required to run their applications and any hardware, networks, and physical security

# 2 - Exploring Data Transformation with Google Cloud

## The Value of Data

### How Data Creates Value

- Data is an essential ingredient for driving innovation and differentiation and is the key to unlocking value from artificial intelligence
  - However, the most valuable insights no longer come just from sales, inventory, and personnel data
  - They are often hidden across unstructured data points from a myriad of sources and systems

### Unlocking business value from data

- Data can be categorized into three main types:
  - Structured
  - Semi-structured
  - Unstructured
- **Structured data = highly organized and well-defined**
  - It's typically stored in a table with relationships between the different rows and columns, like in a spreadsheet or database
  - Structured Data is easy to analyze
  - For example, it's common for organizations to use structured data and customer relationship management tools (CRMs), as they follow customer behavior patterns and trends
- **Semi-structured data = organized into a hierarchy, but without full differentiation or any particular ordering**
  - Examples include emails, HTML, JSON, and XML files
  - Although this data type doesn't have a formal structure, it contains tags or other markers that make it easier to analyze than unstructured data
- **Unstructured data = is information that either doesn't have a predefined data model or isn't organized in a predefined manner**
  - Categories include
    - Text generated/collected from sources: documents, presentations, or even social media posts
    - Data files like images, audio files, and videos
    - Infrastructure activity and performance data like log files from servers, networks, and applications or output data from Internet of things (IoT) sensors
  - Historically difficult to analyze yet represents 80% to 90% of all new enterprise data
- With the right Cloud tools, businesses can extract value from unstructured data by using machine learning to discover trends or use APIs to extract structure from the data
  - An example of an API is **Google Cloud's Vision API** (GCP Product), which uses machine learning to detect products within a picture and can then even label the picture to describe its contents

### Data Management Concepts

#### Database

- **Database = organized collection of data stored in tables (designed to capture data for storage, retrieval, and use)**

##### Relational Database

- **Relational database = stores and provides access to data points that are related to one another**
  - This means storing information in tables, rows, and columns that have a clearly defined schema that represents the structure or logical configuration of the database
- A relational database can establish links or relationships between information by joining tables, and structured query language or SQL can be used to query and manipulate data
- Relational databases are highly consistent, reliable, and best suited for dealing with large amounts of structured data
  - They're designed for business data processing and storing the online transactional data needed to support the daily operations of a company

##### Non-Relational Database == NoSQL Database

- **Nonrelational database == NoSQL database == is less structured in format and doesn't use a tabular format of rows and columns like relational databases**
  - Instead, nonrelational databases follow a flexible data model, which makes them ideal for storing data that changes its organization frequently, or for applications that handle diverse types of data
  - This includes when large quantities of complex and diverse data need to be organized, or when the data regularly evolves to meet new business requirements
- Choosing the right database depends on the use case
- Google Cloud relational database products include Cloud SQL and Cloud Spanner, while Bigtable is a non relational database product (GCP Product)

#### Data Warehouse

- **Data warehouse == place to store and ANALYSE semi-structured/structed data**
- A data warehouse is an enterprise system used for the analysis and reporting of structured and semi-structured data from multiple sources
  - Think of the data warehouse as the central hub for all business data
  - Business data might include:
    - point of sale transactions
    - marketing automation
    - customer relationship management data
- A data warehouse is suited for both ad hoc analysis and custom reporting and can help analyze sales and identify trends because it can store both current and historical data in one place
  - This capability can provide a long range view of data over time, which makes a data warehouse a primary component of business intelligence
- BigQuery is Google Cloud's data warehouse offering (GCP Product)
- Although data warehouses handle structured and semi structured data, they're NOT typically the answer for how to handle large amounts of available unstructured data like images, videos, and documents
- Unstructured data which doesn't conform to a well-defined schema is often disregarded in traditional analytics

#### Data Lake

- **Data lake = a repository designed to ingest, store, explore, process, and analyze any type or volume of raw data, regardless of the source, like operational systems, web sources, social media or Internet of things (IoT)**
- It can store different types of data in its original format, ignoring size limits and without much preprocessing or adding structure
  - Having this unprocessed raw data available for analysis prevents unintentionally contaminating the data or adding bias
  - It also means that raw data can be enriched by merging it with other data at the same time
  - This differs from a data warehouse that contains structured data that has been cleaned and processed ready for the strategic analysis based on predefined business needs
- Data lakes often consist of many different products depending on the nature of the data that is ingested
  - For example, the best Google Cloud products (GCP Product) for storing structured data are Cloud SQL, Cloud Spanner, or BigQuery
  - For semi-structured data, the options include Datastore and Bigtable
  - And for storing unstructured data, Cloud storage is an option
- Data warehouses and data lakes should be considered complementary instead of competing tools (data warehouse vs data lake)
  - Although both store data in some capacity, each is optimized for different uses
  - Data warehouse users = business intelligence analysts who are closer to the business and focus on driving insights from data
    - These users traditionally use the data to answer questions
  - Data lake users = analysts + data engineers and data scientists
    - They're closer to the raw data with the tools and capabilities to explore, mine, and experiment with the data
    - These users find answers in the data, but they also find questions

### Role of Data in Digital Transformation

- First party data = internal information
- Second party = Third party data = external information (usually data about customers and industry), often called second or third-party data
- **First-party data = Proprietary customer datasets that a business collects from customer or audience transactions and interactions**
  - These datasets might include information about digital interactions, like the length of time a user spends at a web page
- **Second-party data = First-party data from another organization, such as a partner or other business in their supply chain that can be easily deployed to augment a company's internal datasets**
  - The organization does not directly own this data, but it is relevant to their business
- **Third-party data = Datasets collected and managed by organizations that do not directly interact with an organization's customers or business**
  - These datasets might come from government, nonprofit, or academic sources like weather or public demographic data, or from industry specific sources like analysts reports, or industry benchmarking
  - Third-party data is often shared or purchased on data marketplaces or exchanges such as the Google Cloud Marketplace (GCP Product)
  - Using external data can greatly increase the value of data by providing new context and insights
- Let's explore an example of how an airline transform their business through data
  - Budget airlines don't provide food as part of their service, instead they charge customers for meals if they want them
    - The solution might seem cost effective, but it can be difficult to estimate the number of meals required on board
    - If the airline overestimates the number of meals needed, they risk wasting food and losing revenue
    - But if they underestimate, they risk selling out of food, providing poor customer service, and losing potential revenue
  - One budget airline in Asia reimagined how they could solve this problem by using data
    - They began by identifying factors to help estimate stock, such as the size of the plane and the number of passengers
    - But they soon discovered that estimates based on these factors were inaccurate
    - This meant having to think about their data differently by analyzing information such as destination, time of flight, and flight connections before and after each journey
    - Using this info they learned that flights to and from India required 73% more vegetarian meals
    - With these new insights, the airline was able to predict the number of meals required more accurately, which in turn provided a more positive customer experience and improve the profitability of their food service

### Data Value Chain

```
Data Value Chain = Data Genesis -> Data Collection -> Data Processing -> Data Storage -> Data Analysis -> Data Activation
```

- When you think about data processing, it's important to place it within the broader context of the data value chain
- Imagine data traveling along an assembly line, like a car in a factory
  - The assembly line progressively adds parts and value to an object that moves along it
  - Raw data at the beginning of the line is eventually transformed into actions that humans or machines take
- Let's examine the steps in this data value chain
  - **Data Genesis = Initial creation of a unit of data**
    - This could be a click on a website, the swipe of a card, a sensor recording from an IoT device, or countless other examples
    - It's the raw material that will eventually be turned into an insight ready for action
  - **Data collection = Bringing that initial unit of data to the assembly line through ingestion**
    - The basic function of **Data ingestion = Extraction of data from the system in which it's hosted and bring it to a new system**
      - It could have dramatically different requirements based on the volume, velocity, and variety of the raw data that's required for a given analysis and how fast the data needs to be analyzed
  - **Data Processing = is where the collected raw data is transformed into a form that's ready to derive insights from**
    - The data will likely need to be adjusted for example, by merging different datasets together
    - It can be a single-stage operation or can be a complex tree of cascading procedures
    - In our manufacturing process analogy, this phase is where raw materials take the shape of the pre-assembly parts of a manufactured product
  - **Data Storage = Where the data lands can be found and is ready for analysis and action**
    - As with real-world manufacturing, where storage options vary depending on the type of product that is processed, different types of data can be stored in different ways
    - For example, NoSQL is available for fast reads and writes, data warehousing for fast access to analysis, and object storage for unstructured data
    - There are also customized options of these standard stores
    - Data analysis provides direction for business-oriented action
    - To continue with our manufacturing line analogy in this stage, inputs from the data processing stage are assembled into a final product
  - **Last step = Data Activation = pushing of data to relevant business procedures and decision makers**
    - When an analysis is produced, it needs to be pushed to the relevant business procedures and decision-makers so that action can be taken and the value chain completed
    - The most common points of activation are applications that make automated decisions, and business intelligence dashboards that guide humans toward better, more informed decisions
    - In our manufacturing line example, this is the step where a fully produced product is put to its intended use
    - **value chain principles = We want to use raw data to perform actions that benefit the business**

### Data Governance

- An effective data governance program can help implement data directives to achieve democratisation and embedding of data and ensure that it's secure and protected from unauthorized use
- **Data governance = setting internal standards, data policies that apply to how data is gathered, stored, processed, and disposed of**
  - It governs who can access certain data, what data is under governance
  - It also involves complying with external standards set by industry associations, government agencies, and other stakeholders
- Data governance focuses on making the data available to all stakeholders across the full life cycle of the data in a form that they can readily access and use, in a manner that generates the desired business outcomes through insights and analysis, and if relevant, in a way that conforms to regulatory standards and compliance needs

#### Benefits of Data Governance

- It makes data more valuable
  - Data Governance implements processes to ensure high quality data and provides a platform that makes it easier to share data securely with stakeholders across the organization
- It helps users make better, more timely decisions, through data governance
  - Users throughout an organization get the data they need to reach and service customers, design and improve products and services and seize opportunities for new revenues
  - By democratizing data, organizations can embed data in all decision making
- It improves cost controls
  - Data helps organizations manage resources and operate more efficiently
  - Because they can eliminate data duplication caused by information silos, they don't overbuy and have to maintain expensive hardware
- It enhances regulatory compliance
  - An increasingly complex regulatory climate has made it more important for organizations to establish rigorous data governance practices
  - They avoid risks associated with noncompliance and proactively anticipate new regulations
- It helps earn greater trust from customers and suppliers
  - By being in auditable compliance with both internal and external data policies, organizations gain the trust of customers and partners
- It helps manage risk
  - With robust data governance, organizations can reduce concerns about exposure of sensitive data to individuals or systems who lack proper authorization
  - Security breaches from malicious, outsiders, or even insiders who access data they don't have the right to see
- It allows more personnel access to more data
  - Strong data governance provides confidence that the right personnel get access to the right data and that this democratization of data does not negatively impact the organization
- It's possible that organizations without an effective data governance program will suffer from compliance violations
  - This can lead to fines, poor data quality which generates lower quality insights that impact business decisions

### Quiz

Q1 - An online retailer uses a smart analytics tool to ingest real-time customer behavior data to surface the best suggestions for particular users. How can machine learning guide this activity?

- **Through machine learning, with every click that the user makes, their website experience becomes increasingly personalized**
- Machine learning can help identify user behavior in real time, but cannot make personalized suggestions based on the data
- Through machine learning, a user's credit card transactions can be analyzed to determine regular purchases
- Machine learning can be used to make all users see the same product recommendations, regardless of their preferences or behavior

Q2- Which data type is highly organized and well-defined?

- **Structured data**
- Semi-structured data
- A hybrid of structured, semi-structured, and unstructured data
- Unstructured data

Q3 - New cloud tools make it possible to harness the potential of unstructured data. Which of these use cases best demonstrates this?

- Analyzing historical sales figures to predict future trends
- Creating visualizations from seasonal weather data
- Using GPS coordinates to power a ride-sharing app
- **Analyzing social media posts to identify sentiment toward a brand**

Q4 - A car insurance company has a large database that stores customer details, including the vehicles they own and past claims. The structure of the database means that information is stored in tables, rows, and columns. What type of database is this?

- A non-relational database
- An XML database
- **A relational database**
- An object database

Q5 - Which is a repository designed to ingest, store, explore, process, and analyze any type or volume of raw data, regardless of the source?

- **Data lake**
- Data warehouse
- Data archive
- Database

Q6 - What is Google Cloud's modern and serverless data warehousing solution?

- Cloud Storage
- Vertex AI
- **BigQuery**
- Compute Engine

Q7 - Which represents the proprietary customer datasets that a business collects from customer or audience transactions and interactions?

- Second-party data
- Third-party data
- **First-party data**

Q8 - A solar energy company wants to analyze weather data to better understand the seasonal impact on their business. On which platform could they find free-to-use weather datasets?

Google Play
Google Cloud console
Google Cloud Marketplace
App Engine

Q9 - Which step in the data value chain is where collected raw data is transformed into a form that's ready to derive insights from?

- Data genesis
- Data analysis
- Data storage
- **Data processing**

Q10 - What is data governance?

- The process of deleting unnecessary data to save storage space
- The process of collecting and storing data for future use
- The process of analyzing data to gain insights and make informed decisions
- **The process of setting internal data policies and ensuring compliance with external standards**

## Google Cloud Data Management Solutions

- Google Cloud offers several core storage products (GCP Product)
  - Cloud Storage
  - Cloud SQL
  - Cloud Spanner
  - Big Query
  - Firestore
  - Cloud Bigtable
- Depending on your use case, you might use one or several of these services to do the job

### Unstructured data storage

#### Cloud Storage

- **Cloud Storage = Service that offers developers and IT organizations durable and highly available object storage**
  - **Object storage = A computer data storage architecture that manages data as objects (binary form of actual data + relevant associated metadata + globally unique identifier)** instead of as file storage, which is a file and folder hierarchy, or as block storage, which is chunks of a disc
  - These objects are stored in a packaged format that contains the binary form of the actual data and relevant associated metadata such as creation date, author, resource type and permissions and a globally unique identifier
  - _These unique keys are in the form of URLs, which means object storage interacts well with web technologies_
  - _Data commonly stored as objects include video, pictures, and audio recordings_
  - This type of data is referred to as unstructured, which means that it doesn't have a predefined data model or isn't organized in a predefined manner as you might find in a structured database format
- Cloud storage lets customers store any amount of data and retrieve it as often as needed
- It's a fully managed, scalable service that has a wide variety of uses, such as serving website content, storing data for archival and disaster recovery and distributing large data objects to end users through direct download
- There are **4 primary storage classes in Cloud storage**
  - 1. **Standard storage = best for frequently accessed or hot data**
    - It's also great for data that's stored for only brief periods of time
  - 2. **Nearline storage = storing infrequently accessed data (once per monthly)**
    - This option is best for storing infrequently accessed data, like reading or modifying data on average once a month or less. Examples might include data backups, long tail multimedia content, or data archiving
  - 3. **Coldline storage = this is also a low cost option for storing infrequently accessed data (once every 90 days)**
    - Compared to "nearline storage", "coldline storage" is meant for reading or modifying data at most, once every 90 days
  - 4. **Archive storage = lowest cost option used, ideally, for data archiving, online backup and disaster recovery (once a year)**
    - It's the best choice for data that you plan to access less than once a year because it has higher costs for data access and operations and a 365 day minimum storage duration

##### Benefits of Cloud Storage

- Although each of these four classes have differences, it's worth noting there are several characteristics that apply across all of these storage classes which include
  - _Unlimited storage with no minimum object size requirement_
  - _Worldwide accessibility and locations_
  - _Low latency_
  - _High durability_
  - _Uniform experience which extends to security tools and API's_
  - _Geo redundancy_
    - If data is stored in a multi region or dual region, this means placing physical servers in geographically diverse data centers to protect against catastrophic events and natural disasters, and load balancing traffic for optimal performance
  - _auto class_
    - Cloud storage also provides a feature called "auto class" which automatically transitions objects to appropriate storage classes based on each object's access pattern. The feature moves data that's not accessed to colder storage classes to reduce storage cost and moves data that is access to standard storage to optimize future accesses
    - Auto class simplifies and automates cost saving for your Cloud storage data

### Structured Data Storage

- Structured data consists of numbers and values that are organized in a predefined format that's easily searchable in a relational database
- A relational database stores information in tables, rows and columns, that have a clearly defined schema that represents the structure or logical configuration of the database

#### Cloud SQL

- **Cloud SQL = offers fully managed relational databases, including MySQL, PostgreSQL and SQL server, as a service**
  - It's designed to transfer mundane, but necessary and often time-consuming tasks to Google, like applying patches and updates, managing backups, and configuring replications so you can focus on building great applications

##### Benefits of Cloud SQL

- It doesn't require any software installation or maintenance
- It supports managed backups, so backed up data is securely stored and accessible if a restore is required
- It encrypts customer data when on Google's internal networks and when stored in database tables, temporary files and backups
- It includes a network firewall which controls network access to each database instance

#### Cloud Spanner

- **Cloud Spanner = a fully managed, mission, critical relational database service that scales horizontally to handle unexpected business spikes**
- Cloud Spanner is especially suited for applications that require a SQL relational database management system with joins and secondary indexes built in high availability, which provides data redundancy to reduce downtime when a zone or instance becomes unavailable, the goal is to prevent a single point of failure. -
- Strong global consistency, which ensures that all locations where data is stored are updated to the most recent data version quickly, and high numbers of input and output operations per second, tens of thousands of reads and writes per second or more

#### Cloud SQL vs Cloud Spanner

- **Cloud SQL = a fully managed relational database service for MySQL, PostgreSQL, and SQL server with greater than 99.95% availability**
  - Database migration service, DMS, makes it easy to migrate your production databases to Cloud SQL with minimal downtime
- **Cloud Spanner = which is a fully managed relational database with unlimited scale, strong consistency, and up to 99.999% availability with zero downtime for planned maintenance and schema changes**
  - This globally distributed acid compliant Cloud database automatically handles replicas, sharding, and transaction processing so you can quickly scale to meet any usage pattern and ensure success of products
- If you've outgrown any relational database, are sharding your databases for throughput, high performance, need transactional consistency, global data and strong consistency, or just want to consolidate your database, consider using Cloud Spanner
- If you don't need horizontal scaling or a globally available system, Cloud SQL is a cost-effective solution

#### BigQuery

- **BigQuery = a fully managed data warehouse**
  - Data warehouse = a large store that contains petabytes of data gathered from a wide range of sources within an organization and is used to guide management decisions
- Because it's fully managed, BigQuery takes care of the underlying infrastructure, so users can focus on using SQL queries to answer business questions without having to worry about deployment, scalability, and security
- **BigQuery provides two services in one**
  - 1. **Storage**
  - 2. **Analytics**
- It's a place to store petabytes of data
  - For reference, one petabyte is equivalent to 11,000 movies at 4K quality
- BigQuery is also a place to analyze data with built-in features like machine learning, geospatial analysis, and business intelligence
- Data in BigQuery is encrypted at rest by default, without any action required from a user
  - Encryption at rest is encryption used to protect data that's stored on a disc, including solid state drives or backup media
- BigQuery provides seamless integration with the existing partner ecosystem
  - Businesses can tap into our ecosystem of system integrators and data integration partners to help enhance analytics and reporting
  - These integrations mean that BigQuery lets organizations make the most of existing investments in business intelligence, data ingestion, and data integration tools
  - Industry research shows that 90% of organizations have a multi Cloud strategy, which adds complexity to data integration, orchestration, and governance
  - BigQuery works in a multi Cloud environment, which lets data teams eradicate data silos by using BigQuery to securely and cost effectively analyze data across multiple Cloud providers
  - BigQuery also has built in machine learning features so that ML models can be written directly in BigQuery by using SQL
  - If other professional tools such as Vertex AI from Google Cloud are used to train ML models, datasets can be exported from BigQuery directly into Vertex AI for a seamless integration across the data to AI life cycle

### Semi Structured Data

- Semi structured data has some defining or consistent characteristics, but generally doesn't follow a structure as rigid as a relational database
- Semi structured data is easier to organize because it usually contains some organizational properties such as tags or metadata
  - An example of unstructured data is an email message
  - While the actual content of the email is unstructured, it does contain structured data such as the name and email address of the sender and recipient, the time sent, and so on
- Google Cloud offers two semi structured data storage products, Firestore and Cloud Bigtable (GCP Product)
  - Firestore is a flexible, horizontally scalable NoSQL Cloud database for storing and syncing data in real time
    - Firestore can be directly accessed by mobile and web applications
    - Firestore performs data storage in the form of documents, with the documents being stored in collections
    - Documents support a wide variety of data types, such as nested objects, numbers, and strings
    - One of Firestore's main features is automatic scaling
      - It's been designed to scale automatically depending on user demand, but retains the same level of performance irrespective of database size
    - Firestore also provides offline usage through a comprehensive database on users devices
    - Offline data access ensures that applications run without interruption, even if the user gets disconnected from the Internet
  - Cloud Bigtable, Google's NoSQL, big data database service
    - It's the same database that powers many core Google services including Search Analytics, Maps, and Gmail
    - Bigtable is designed to handle large workloads at consistent low latency, which means Bigtable responds to requests quickly and high throughput, which means it can send and receive large amounts of data
    - For this reason, it's a great choice for both operational and analytical applications, including Internet of Things, user analytics, and financial data analysis
- When deciding on a storage option, you might choose Bigtable
  - Working with more than 1TB of semi structured or structured data,
  - Data is fast with high throughput or it's rapidly changing,
  - Working with NoSQL data,
  - Data is a time series or has natural ordering
  - Working with big data and running batch or real time processing on the data,
  - Running machine learning algorithms on the data

### Choosing the right storage product

- Combination of **Data Type + Business Need**
- **Unstructured Data = Cloud Storage**
  - You have to decide a storage class, standard near line, code line or archive, or whether to let the auto class feature decide that for you
- **Structured/Semi-Structured Data = Depends on Transactional/Analytical Workload**
  - Transactional workloads stem from online transaction processing (OLTP =) systems, which are used when fast data inserts and updates are required to build row based records
    - E.g. Point of sale transaction records
  - Analytical workloads which stem from online analytical processing (OLAP =) systems, which are used when entire datasets need to be read
    - They often require complex queries, for example, aggregations
    - E.g. Analyzing sales history to see trends and aggregated views
  - After you determine if the workloads are transactional or analytical, you must determine whether the data will be accessed by using SQL
    - **Transactional + SQL = Cloud SQL and Cloud Spanner are two options**
      - Cloud SQL works best for local to regional scalability
      - Cloud Spanner is best to scale a database globally
    - **Transactional + NoSQL = Firestore**
      - Firestore is a transactional NoSQL document oriented database
    - **Analytical + SQL = BigQuery**
      - BigQuery is Google's data warehouse solution lets you analyze petabyte scale datasets
    - **Analytical + NoSQL = Cloud Bigtable**
      - Cloud Bigtable provides a scalable no SQL solution for analytical workloads and is best for real time high through put applications that require only millisecond latency

### Database Migration

- Running modern applications on legacy on-premises databases requires overcoming expensive, time-consuming challenges around latency, throughput, availability, and scaling

#### Method 1 - Lift and Shift Platform Migration

- The most straightforward method is a lift and shift platform migration
- **Lift and Shift = Where databases are migrated from on-premises and private Cloud environments to the same type of database hosted by a public cloud provider such as Google Cloud**
- Although this solution makes the database more difficult to modernize, it does bring with it the benefits of minimal upheaval, and having data and infrastructure managed by the Cloud provider

#### Method 2 - Managed Database Migration

- **Managed Database Migration = Allows migration of databases from SQL server, MySQL, PostgreSQL, and others to a fully managed Google Cloud database**
- Although this migration requires careful planning and might cause slight upheaval, a fully managed solution lets you focus on higher-priority work that really adds value to your organization
- Google Cloud's **Database Migration Service (DMS =)** (GCP Product), can easily migrate your databases to Google Cloud,
- GCP Product: **Datastream** can be used to synchronize data across databases, storage systems, and applications
- Example
  - Let's look at a real-life use case, with 18 fulfillment centers, 38 delivery centers, and a catalog of more than 22 million items
  - The online retailer Wayfair needed a way to quickly move from their on-premises data centers, which ran on SQL server, to Google Cloud
  - This had to be achieved without inconveniencing their team of over 3,000 engineers, their tens of millions of customers, or their 16,000 supplier partners
  - The goal was to lift and shift their workloads as quickly as possible with minimal changes, and then use Cloud databases to modernize those workloads
  - By using _Cloud SQL server_, Google Cloud provided the flexibility to be deliberate about which engine and product to run Wayfair systems on going forward
  - They liked how they could run SQL server on virtual machines, VMs for example, but could also benefit from database offerings like Cloud SQL and Cloud Spanner
  - Now that migration is complete, they also use _Google Cuponet's Engine GKE_ and _Compute Engine VMs_ to host the services built by the Google Cloud Team
  - They also use _Pub-Sub_ and _Dataflow_ for sending operational data, to their analytical store in big query

### Quiz

Q1 - Data in the form of video, pictures, and audio recordings is well suited to object storage. Which product is best for storing this kind of data?

- BigQuery
- **Cloud Storage**
- Firestore
- Cloud SQL

Q2 - A data analyst for an online retailer must produce a sales report at the end of each quarter. Which Cloud Storage class should the retailer use for data accessed every 90 days?

- Archive
- Standard
- **Coldline**
- Nearline

Q3 - Which characteristic is true for all Cloud Storage classes?

- Accessibility only within one region
- High latency and low durability
- **Geo-redundancy if data is stored in a multi-region or dual-region**
- Maximum storage limits

Q4 - Which is the best SQL-based storage option for a transactional workload that requires local or regional scalability?

- Cloud Bigtable
- Cloud Spanner
- **Cloud SQL**
- Cloud Storage

Q5 - What are the two services that BigQuery provides?

- Migration and analytics
- **Storage and analytics**
- Compute and analytics
- Networking and storage

Q6 - BigQuery works in a multicloud environment. How do organizations benefit from this feature?

- Security is more effective when BigQuery is run in on-premises environments
- Multicloud support in BigQuery is only intended for use in disaster recovery scenarios
- BigQuery lets organizations save costs by limiting the number of cloud providers they use
- **Data teams can eradicate data silos by analyzing data across multiple cloud providers**

Q7 - What is Google's big data database service that powers many core Google services, including Google Search, Google Analytics, Google Maps Platform, and Gmail?

- **Cloud Bigtable**
- Cloud Spanner
- Cloud SQL
- Cloud Storage

Q8 - Which would be the best SQL-based storage option for a transactional workload that requires global scalability?

- **Cloud Spanner**
- Cloud SQL
- Cloud Bigtable
- Firestore

Q9 - Which strategy describes when databases are migrated from on-premises and private cloud environments to the same type of database hosted by a public cloud provider?

- Managed database migration
- Remain on-premises
- Refactoring
- **Lift and shift**

Q10 - Which Google Cloud product can be used to synchronize data across databases, storage systems, and applications?

Dataprep
Dataproc
**Datastream**
Pub/Sub

## Making Data Useful + Accessible

### Business intelligence and insights using Looker

- Some solutions are too complex and not accessible by those outside the data engineering or data analysis teams
  - The this means other teams have to put in requests and wait for answers which defeats the purpose of gaining real-time insights
- Other solutions let everyone in the business perform their own data analysis, but they can only perform their analysis with a selection of the available data
  - This means that only a few people or possibly no one, has a full view of the organization's business data
- **Looker = Google Cloud business intelligence platform (GCP Product) designed to help individuals and teams analyze, visualize and share data**
  - This includes creating interactive dashboards and reports that are easy to understand and share
  - By having a reliable authority for business data, anyone on a team can explore it, ask and answer their own questions, and create visualizations
  - This approach empowers organizations to not just uncover insights, but also act on them
  - Looker supports BigQuery, along with more than 60 different SQL databases
  - Together, BigQuery and Looker provide rich interactive dashboards and reports without compromising performance, scale, security or data freshness
  - Looker is also 100% web based, which makes it easy to integrate into existing workflows and share with multiple teams at an organization

### Streaming Analytics

- Batch processing often processes large volumes of data at the same time with long periods of latency
  - An example is payroll and billing systems that have to be processed on either a weekly or monthly basis
- **Streaming analytics = the processing and analyzing of data records continuously instead of in batches**
  - Generally, streaming analytics is useful for all types of data sources that send data in small sizes, often in kilobytes, in a continuous flow as the data is generated
  - This results in the analysis and reporting of events as they happen
  - Sources of streaming data include equipment sensors, clickstreams, social media feeds, stock market quotes, app activity, and more
  - Companies use streaming analytics to analyze data in real time and provide insights into a wide range of activities such as metering, server activity, geolocation of devices or website clicks
  - Use cases include
    - E-commerce
      - User clickstreams can be analyzed to optimize the shopping experience with real time pricing, promotions, and inventory management
    - Financial services
      - Account activity can be analyzed to detect abnormal behavior in the data stream and generate a security alert
    - Investment services
      - Market changes can be tracked in settings adjusted to customer portfolios based on configure constraints such as selling when a certain stock value is reached
    - News media
      - User click records can be streamed from various news source platforms, and the data can be enriched with demographic information to better serve articles that are relevant to the targeted audience
    - Utilities
      - Throughput across a power grid can be monitored and alerts generated, or workflows initiated when established thresholds are reached
- Google Cloud offers two main streaming analytics products **Pub/Sub** and **DataFlow** (GCP Product) to ingest, process, and analyze event streams in real time, which makes data more useful and accessible from the instant it's generated
  - **Pub/Sub** ingests hundreds of millions of events per second, but **Dataflow** unifies streaming in batch data analysis and builds cohesive data pipelines
  - A data pipeline = a series of actions or stages that ingest raw data from different sources and then move that data to a destination for storage and analysis

### PubSub + Dataflow

- One of the early stages in a Data pipeline is Data Ingestion, which is where large amounts of streaming data are received
- Data, however, might not always come from a single structured database
- Instead, the data might stream from a thousand or even a million different events that are all happening asynchronously
- A common example of this data is from IoT, or Internet of Things applications
  - These can include sensors on taxis that send out location data every 30 seconds or temperature sensors around a data center to help optimize heating and cooling
- **Pub/Sub (PubSub) is a distributed messaging service that can receive messages from various device streams, such as gaming events, IoT devices, and application streams**
  - The name is short for Publisher/Subscriber or Publish messages to subscribers
  - After messages have been captured from the streaming input sources, you need a way to pipe that data into a data warehouse for analysis
- This is where Dataflow comes in
  - **Dataflow creates a pipeline to process both streaming data and batch data**
  - Process, in this case, refers to the steps to extract, transform, and load data, sometimes referred to as _ETL = Extract Transform Load Data_
  - A popular solution for pipeline design is Apache Beam
    - It's an open source, unified programming model to define and execute data processing pipelines, including ETL, batch, and stream processing
  - Dataflow handles much of the complexity for infrastructure setup and maintenance and is built on Google's infrastructure
    - This product allows for reliable auto scaling to meet data pipeline demands
    - Dataflow is serverless and fully managed
    - Serverless computing means that software developers can build and run applications without having to provision or manage the backend infrastructure
    - For example, Google Cloud manages infrastructure tasks on behalf of the users, like resource provisioning, performance tuning, and ensuring pipeline reliability
    - And a fully managed environment is one where software can be deployed, monitored, and managed without needing an operations team
    - You can create this environment by using automation tools and technologies
    - Using a serverless and fully managed solution like Dataflow means that you can spend more time analyzing the insights from your datasets and less time provisioning resources to ensure your pipeline will successfully complete its next cycles

### Quiz

Q1 - What Google Cloud business intelligence platform is designed to help individuals and teams analyze, visualize, and share data?

- Dataplex
- Dataflow
- **Looker**
- Cloud Storage

Q2 - What feature of Looker makes it easy to integrate into existing workflows and share with multiple teams at an organization?

- It creates easy to understand visualizations
- It supports over 60 different SQL databases
- It's cost effective
- **It's 100% web based**

Q3 - Streaming analytics is the processing and analyzing of data records continuously instead of in batches. Which option is a source of streaming data?

- Medical test results
- Payroll records
- Customer email addresses
- **Temperature sensors**

Q4 - What is Google Cloud's distributed messaging service that can receive messages from various device streams such as gaming events, Internet of Things (IoT) devices, and application streams?

- Dataproc
- **Pub/Sub**
- Looker
- Dataplex

Q5 - Which statement is true about Dataflow?

- **It handles infrastructure setup and maintenance for processing pipelines**
- It allows easy data cleaning and transformation through visual tools and machine learning-based suggestions
- It's a messaging service for receiving messages from various device streams
- It's a cloud-based data warehouse for storing and analyzing streaming and batch data

Q6 - What does ETL stand for in the context of data processing?

- Enhanced transaction logic
- Event-time logic
- Enrichment, tagging, and labeling
- **Extract, transform, and load**

# 3 - Innovating with Google Cloud Artificial Intelligence

## AI + ML Fundamentals

### Defining AI + ML

- **AI = Artificial intelligence = Broad field which refers to the use of technologies to build machines and computers that can mimic cognitive functions associated with human intelligence**

- **ML = Machine learning = Subset of AI that lets a machine learn from data without being explicitly programmed**
  - It relies on various models to analyze large amounts of data, learn from the insights, and then make predictions and informed decisions

### How AI + ML differ from data analytics + business intelligence

- Both the dashboard and the report are examples of backward looking data
  - They look at what happened in the past
- Most data analysis and business intelligence is based on historical data, used to calculate metrics or identify trends
  - But to create value in your business, you need to use that data to make decisions for future business

### Problems that ML is suited to solve

1. Replacing or simplifying rule based systems
2. Automating processes (make predictions and repeated decisions at scale)
3. Understanding unstructured data e.g. images, videos, audio
4. Personalisation/Personalised Recommendations (e.g. YouTube)

### Why ML required high-quality data

- Data is considered low quality if it's not aligned to the problem, or is biased in some way
- To assess it's quality, data is evaluated against six dimensions
  - Completeness = whether all the required information is present
  - uniqueness = cannot identify patterns
  - timeliness = whether the data is up-to-date and reflects the current state of the phenomenon that's being modeled
  - validity = type + format + range = means the data conforms to a set of predefined standards and definitions, such as type and format and ensures the data is in an acceptable range
  - accuracy = correctness of the data (form + content), such as the correct birth date or the accurate number of units sold
  - consistency = whether the data is uniform and doesn't contain any contradictory information

### Responsible and Explainable QI

- The principles state that AI should be:
  - Socially beneficial
  - Avoid creating or reinforcing unfair bias,
  - Be built and tested for safety
  - Be accountable to people, incorporate privacy design principles,
  - Uphold high standards of scientific excellence
  - Be made available for uses that accord with these principles

### Quiz

Q1 - Which option refers to the use of technologies to build machines and computers that can mimic cognitive functions associated with human intelligence?

- Machine learning
- Deep learning
- **Artificial intelligence**
- Natural language processing

Q2 - Which technology relies on models to analyze large amounts of data, learn from the insights, and then make predictions and informed decisions?

- Robotics
- **Machine learning**
- Expert systems
- Natural language processing

Q3 - Google applies generative AI to products like Google Workspace, but what is generative AI?

- A type of artificial intelligence that can create and sustain its own consciousness
- A type of artificial intelligence that can understand and respond to human emotions
- A type of artificial intelligence that can make decisions and take actions
- **A type of artificial intelligence that can produce new content, including text, images, audio, and synthetic data**

Q4 - How do data analytics and business intelligence differ from AI and ML?

- Data analytics and business intelligence involve advanced algorithms for predicting future trends, whereas AI and ML focus on processing historical data
- **Data analytics and business intelligence identify trends from historical data, whereas AI and ML use data to make decisions for future business**
- Data analytics and business intelligence use automated decision-making processes, whereas AI and ML require human intervention and interpretation of data
- Data analytics and business intelligence are used only in small businesses, whereas AI and ML are used exclusively by large corporations

Q5 - Artificial intelligence is best suited for replacing or simplifying rule-based systems. Which is an example of this in action?

- Using AI to replace a human decision-maker in complex situations, such as those involving life-or-death choices
- Implementing AI to develop a new product or service that has never been seen before
- **Training a machine learning model to predict a search result ranking**
- Using a reinforcement learning algorithm to train autonomous drones for package delivery

Q6 - You're watching a video on YouTube and are shown a list of videos that YouTube thinks you are interested in. What ML solution powers this feature?

- Clickbait detection
- Video transcription
- **Personalized recommendations**
- Content moderation

Q7 - Which use case demonstrates ML's ability to process natural language?

- Identifying the artist, title, or genre of a song to create playlists based on the user's listening habits
- Detecting people and objects in surveillance footage to use as evidence in criminal cases
- **Identifying the topic and sentiment of customer email messages so that they can be routed to the relevant department**
- Segmenting images into different parts or regions to extract information, such as the text on a sign

Q8 - Which dimension for measuring data quality means that the data conforms to a set of predefined standards and definitions such as type and format?

- Accuracy
- Uniqueness
- Consistency
- **Validity**

Q9 - What does the consistency dimension refer to when data quality is being measured?

- Whether a dataset is free from duplicate values that could prevent an ML model from learning accurately
- Whether all the required information is present
- **Whether the data is uniform and doesn't contain any contradictory information**
- Whether the data is up-to-date and reflects the current state of the phenomenon that is being modeled

Q10 - Google's AI principles are a set of guiding values that help develop and use artificial intelligence responsibly. Which of these is one of Google's AI principles?

- AI should create or reinforce unfair bias
- **AI should be socially beneficial**
- AI should be accountable to other machines
- AI should be made available for any use

## Google Cloud's AI and ML Solutions

### BigQuery ML

- Although BigQuery started solely as a data warehouse, over time it has evolved to provide additional features that support the data to AI life cycle
  - **BigQuery ML uses machine learning to build and run models by using existing business intelligence tools and spreadsheets**
- Models are trained and access directly in BigQuery by using SQL
- BigQuery ML brings machine learning to the data
- BigQuery ML also integrates with Vertex AI, Google Cloud's end to end AI and ML platform
  - When BigQuery ML models are registered to the Vertex AI model registry, they can be deployed to endpoints for online prediction

### Pre-trained APIs

- Google Cloud's pretrained API's are a great option If you don't have your own training data
- Google Cloud's pre trained API's can help developers build smart apps quickly by providing access to ML models for common tasks like analyzing images, videos, and text
  - API's can be deployed in a virtual private cloud, on premises, or in Google's public cloud regardless of the level of ML experience
- Let's imagine a developer building a mobile app that users will submit photos to the developer needs the app to recognize what the images are and filter out any that aren't safe for work
  - The developer might choose _Vision API_
  - This offers powerful, pre trained machine learning models, which use Google data to automatically detect faces, objects, text, and even sentiment in images
  - The developer can use Vision API to assign labels to images and quickly classify them into millions of predefined categories
- The _natural language API_ is another out of the box, pre trained API
  - If a business has a contact form on its website that receives many messages every day
  - This data can be difficult and time intensive to manually handle, categorize an action
  - Natural language API discovers syntax, entities and sentiment in text and classifies texts into a predefined set of categories
  - In this case, it can decide if comments represent complaints, praise, and attempt to learn more about your business and more
- Google also offers several other pre trained API's
  - The _Cloud Translation API_ converts texts from one language to another
  - The _speech to text API_ converts audio to text for data processing
  - The _text to speech API_ converts text into high quality voice audio. And the
  - _Video intelligence API_ recognizes motion and action in video

### AutoML

- **Vertex AI = Use own data to train models**
- Vertex AI brings together Google Cloud services for building ML under one unified user interface
  - You can use your own training data with Vertex AI to manage and build ML projects
  - This means that after your data is ingested into Vertex AI, **AutoML chooses the best machine learning model for you by comparing different models and tuning parameters**
- Let's go back to our image recognition example, which used Vision API, a pre-existing model trained with Google data
  - Imagine you work for a car manufacturing company
  - Vision API can tell you the difference between generic images found in Google databases, like the difference between a wheel and a door
  - But it can't help a car manufacturer distinguish between good or defective parts
  - In this case, a developer could use an AutoML vision instance and train it with your specialized data
  - This automates the training of machine learning models, which means that you could upload a batch of images and train an image classification model
- Now let's focus on another feature of AutoML. Earlier you saw how the natural language API could be used for processing entries into an online contact form
  - But if your text examples don't fit neatly into the natural language API, sentiment based or vertical topic based classification scheme, and you want to use your own specialized data instead, you need to use AutoML natural language
  - **AutoML natural language** lets you build and deploy custom machine learning models

### Custom Models

- Vertex AI is also the essential platform for creating custom end to end machine learning models
- Vertex AI provides a suite of products to help at each stage of the ML workflow
  - Gathering data
  - Fture engineering
  - Building models
  - Deploying and monitoring those models
- Vertex AI contains tools that assist programmers with virtual machine imaging in data labeling, training, and predictions. It also provides pre-built algorithms. It's important to remember that although these tools are the building blocks to using your data at every stage, there is no one size fits all approach. Every use case requires a different combination of tools and products

### TensorFlow

- All Machine Learning models are built on top of Google Cloud's AI foundational infrastructure
- A part of this foundation is **TensorFlow = end to end open source platform for machine learning**
- TensorFlow has a flexible ecosystem of tools, libraries, and community resources that enable researchers to innovate in ML and developers to build and deploy ML powered applications
- TensorFlow takes advantage of the Tensor Processing Unit, or )TPU =), which is Google's custom developed application specific integrated circuit used to accelerate machine learning workloads
  - TPUs act as domain specific hardware as opposed to general purpose hardware with CPUs and GPUs
  - With TPUs, the computing speed increases more than 200 times
  - This means that instead of waiting 26 hours for results with a state of the art GPU, you only need to wait for 7.9 minutes for a full cloud TPU pod to deliver the same results

### AI Solutions (GCP Products)

- **Contact Center AI = provides models for speaking with customers and assisting human agents, increasing operational efficiency, and personalizing customer care to transform your contact center**
- **Document AI = unlocks insights by extracting and classifying information from unstructured documents such as invoices, receipts, forms, letters, and reports**
  - The extracted data can then be saved in a database or exported to another application for further analysis
- **Discovery AI = for retail uses machine learning to select the optimal ordering of products on a retailer's e-commerce site when shoppers choose a category like winter jackets or kitchen ware**
  - Over time, the AI learns the ideal product ordering for each page on the site by using historical data, optimizing how and what products are shown for accuracy, relevance, and likelihood of making a sale
- **Cloud Talent Solution uses AI with job search and talent acquisition capabilities, matches candidates to ideal jobs faster, and allows employers to attract and convert higher quality candidates**

### Considerations when selecting Google Cloud AI/ML solutions

- **Speed**
  - Custom training usually takes the longest time because it builds the ML model from the beginning, unlike autoML and Big query ML
- **Differentiation**
  - These include image recognition solutions and chatbots, which are quick to deploy and can be applied in various use cases
  - Alternatively, Vertex AI, which is Google Cloud's unified platform for building, deploying, and managing AI solutions, can give ML engineers and data scientists full control of the ML workflow
    - Vertex AI custom training lets you train and serve custom models with code on vertex workbench, which results in highly bespoke ML models
- **Expertise**
  - Another consideration is the expertise required when embarking on an AI or ML project. Infusing AI into business processes requires roles such as data engineers, data scientists, and machine learning engineers among others. Organizations should consider their current team and then determine a people strategy, which could include reusing or repurposing existing resources, upskilling and training current staff, or hiring or working with outside consultants or contractors
- **Effort Required**
  - The final consideration is the effort required to build an AI solution. This depends on several factors, including the complexity of the problem, the amount of data available, and the experience of the team. Google Cloud can help provide solutions for projects at both ends of the scale. However, any AI undertaking will generally require much time, effort, and expertise to have a worthwhile impact on business operations

### Quiz

Q1 - Google Cloud offers four options for building machine learning models. Which is best when a business wants to code their own machine learning environment, the training, and the deployment?

- **Custom training**
- BigQuery ML
- Pre-trained APIs
- AutoML

Q2 - BigQuery ML = is a machine learning service that lets users:

- Build and evaluate machine learning models in BigQuery by using Python and Java
- Seamlessly connect with a data science team to create an ML model
- **Build and evaluate machine learning models in BigQuery by using SQL**
- Export small amounts of data to spreadsheets or other applications

Q3 - An online retailer wants to help users find specific products faster on their website. One idea is to allow shoppers to upload an image of the product they're looking to purchase. Which of Google's pre-trained APIs could the retailer use to expand this functionality?

- **Vision API**
- Speech-to-Text API
- Natural Language API
- Video Intelligence API

Question 4 - A large media company wants to improve how they moderate online content. Currently, they have a team of human moderators that review content for appropriateness, but are looking to leverage artificial intelligence to improve efficiency. Which of Google's pre-trained APIs could they use to identify and remove inappropriate content from the media company's website and social media platforms.

Speech-to-Text API
Vision API
**Natural Language API**
Video Intelligence API

Q5 - Which feature of Vertex AI lets users build and train end-to-end machine learning models by using a GUI (graphical user interface), without writing a line of code.

- **AutoML**
- MLOps
- Managed ML environment
- Custom training

Q6 - What's the name of Google's application-specific integrated circuit (ASIC) that is used to accelerate machine learning workloads?

- Central Processing Unit (CPU)
- Graphic Processing Unit (GPU)
- Vertex Processing Unit (VPU)
- **Tensor Processing Unit (TPU)**

Q7 - Which Google Cloud AI solution is designed to help businesses improve their customer service?

- Document AI
- **Contact Center AI**
- Cloud Talent Solution
- Discovery AI for Retail

Q8 - Which Google Cloud AI solution is designed to help businesses automate document processing?

- **Document AI**
- Cloud Talent Solution
- Discovery AI for Retail
- Contact Center AI

# 4 - Modernize Infrastructure and Applications with Google Cloud

## Important cloud migration terminology

- **Workload = a specific application, service, or capability that can be run in the Cloud or on premises**
  - Workloads include containers, databases, and virtual machines
  - **Retiring a workload = means removing it from a platform**
    - A workload might be retired because it's unnecessary, not cost effective, secure, or compatible with a specific platform
  - **Retaining a workload = means that it's intentionally kept**
    - When a workload is retained, it's typically kept on premises or in a hybrid Cloud environment
    - This means that the workload will continue to be managed by the business and will not be subject to the same level of Cloud provider control
- **Rehost = Migration of a workload to the Cloud without changing anything in the workload's code or architecture = Lift and Shift**
  - This is often done as a first step in Cloud migration because it's the simplest and quickest way to run a workload in the Cloud
  - Drawbacks/Negatives:
    - Does NOT use all the benefits of Cloud computing
    - Managing workloads that were rehosted without making any changes can be difficult
    - Scaling workloads that were re hosted without making any changes can also be difficult
- **Replatform = Process of migrating a workload to the Cloud while making some changes to the workloads code or architecture = Move and improve**
  - Replatforming lets organizations benefit from the Cloud's scalability, reliability and cost effectiveness, improve the performance of their workloads, and reduce the cost of their workloads
  - Drawbacks/Negatives:
    - Ccomplex and time consuming process
    - Making the necessary changes to the workload's code or architecture can be difficult and testing the changes to the workload's code or architecture can also be difficult
    - Refactoring needed
- **Reimagine = process of rethinking how an organization uses technology to achieve its business goals**
  - This can involve reconsidering the organization's current Cloud strategy and its use of other technologies such as artificial intelligence and machine learning
  - Reimagining Cloud computing can help organizations to improve their efficiency, reduce costs, and increase agility. It can also help organizations better meet the needs of their customers and partners

## Modernising Infrastructure in the Cloud

### Benefits of running compute workloads in the cloud

- **TCO = total cost of ownership = s a measure of the total cost of a system or solution over its lifetime**
  - It includes the cost of the initial purchase, maintenance and operation, along with any other associated costs
  - Cloud computing can help businesses save money on IT costs by eliminating the need to purchase and maintain physical infrastructure
  - Cloud providers offer a pay-as-you-go model, which means that organizations only pay for the resources used
  - They also offer discounts for long term commitments, which can further reduce TCO for businesses that are planning to use Cloud services for a long period
- **Scalability = the ability to increase or decrease the number of resources such as servers, storage, and bandwidth that are available to a Cloud-based application to meet changing demand**
  - Scalability is important because it provides a means to meet changing demand without having to make large upfront investments in infrastructure
  - If a business experiences a sudden spike in demand, it can easily scale up its Cloud resources to meet the demand
  - Conversely, if they experience reduced demand, infrastructure can quickly scale down its Cloud resources to save money
- **Reliability**
  - Cloud providers offer a high degree of reliability and up-time, which gives businesses confidence that their data and applications will be available when they need them
  - Google Cloud for example has multiple data centers located in different parts of the world
    - This helps to ensure that if one data center goes down, the others can continue to operate
  - Monitoring and Detection of Problems
- **Security**
  - Physical data center security + data encryption, identity and access management, network security, virtual private Clouds, and monitoring services that can detect and respond to security threats in real time
  - These security features can also help to ensure compliance with government or industry regulations
- **Flexibility**
  - Running compute workloads in the Cloud offers a high degree of flexibility for organizations
  - Organizations can choose the Cloud services that best meet their needs at any point in time, and then change or adapt those services when necessary
  - For example, a business that needs to increase the amount of storage space that it uses can easily add more storage space to its Cloud storage service
- Abstraction
  - **Abstraction = How Cloud providers remove the need for customers to understand the finer details of the infrastructure implementation by providing management of the hardware, software, and certain aspects of security and networking**
  - For example, a Cloud storage provider might provide a way for customers to store files so that they don't have to worry about the finer details of how the files are stored on the Cloud providers' infrastructure
  - Abstraction also lets Cloud providers offer many services
    - E.g. Google Workspace lets customers run productivity applications so that they don't have to worry about the details of how the applications are actually run or maintained on Google's infrastructure
    - Running compute workloads in the Cloud can help organizations get their products and services to market faster by eliminating the need to develop and maintain their own infrastructure
    - At the same time, it provides a platform for innovation by providing access to the latest technologies and tools as and when they are released

### Virtual Machines

- **Virtualization = A form of resource optimization that lets multiple systems run on the same hardware (VM = )**
- This means that they share the same pool of processing, storage, and networking resources
- VMs enable organizations to run multiple applications at the same time on a server in a way that is efficient and manageable
- **Compute engine** is Google Cloud's infrastructure as a service product (GCP Product), that lets users create and run virtual machines on Google infrastructure
- There are no upfront investments, and thousands of virtual CPUs can run on a system that's designed to be fast and to offer consistent performance
- Each virtual machine contains the power and functionality of a full fledged operating system
- This means a virtual machine can be configured much like a physical server by specifying the amount of CPU power and memory needed, the amount and type of storage needed, and the operating system
- A virtual machine instance can be created through the _Google Cloud Console_, which is a web based tool to manage Google Cloud projects, resources and Google Cloud CLI command line interface by using infrastructure automation tools such as _Terraform_ or the _Compute Engine API_
- An API or application programming interface, is a set of instructions that allows different software programs to communicate with each other
- When you use virtual machines, **compute engine bills by the second with a one minute minimum** and **discounts start for each VM that runs for more than 25% of a month**
- **Compute engine automatically applies a discount for every incremental hour of use**
- Compute engine also offers **committed use discounts for 1 or 3 year period**
  - This means that when committing to use resources for either a one year or three year period, discounts are offered over the on demand prices and then there are preemptable and spot VMs
  - Let's say that a workload doesn't require a human to sit and wait for it to finish, such as a batch job analyzing a large dataset. Costs can be reduced in some cases by up to 90% by choosing preemptable or spot VMs to run the job. **A preemptable or spot VM = VMs that CANNOT be terminated by cloud engine**
  - **Spot VM vs Preemptible VM**
    - _Preemptable VMs can only run for up to 24 hours at a time_
    - _Spot VMs do NOT have a maximum run time_
    - However, the pricing is currently the same for both. F
- Finally, Compute Engine lets users choose the machine properties of their instances, like the number of virtual CPUs, the operating system, and the amount of memory by using a set of predefined machine types, or by creating custom machine types

### Containers

- **Infrastructure as a service (IaaS), or IS = lets users share compute resources with other developers by using virtual machines to virtualize the hardware**
  - This lets each developer deploy their own operating system, access the hardware, and build their applications in a self-contained environment with access to the necessary system resources
  - Containers follow the same principle as virtual machines
    - They provide isolated environments to run software services and optimize resources from one piece of hardware. However, they're even more efficient
    - **VM vs Container**
      - Virtual machines virtualize an entire machine down to the hardware layers
      - Containers only virtualize software layers above the operating system level
      - Containers start faster and use a fraction of the memory compared to booting an entire operating system
- A container is packaged with your application and all of its dependencies, so it has everything it needs to run
  - Containers can be independently developed, tested, and deployed, and are well suited for a microservices based architecture
  - This architecture is made up of smaller individual services that run containerized applications, that communicate with each other through APIs or other lightweight communication methods, such as REST or gRPC
  - Containers let developers create predictable environments isolated from other system resources
  - So if a customer asks for a new feature or a change in the application, developers can easily make an update to that particular part of the application without affecting the REST
  - Containers can run virtually and anywhere, which makes development and deployment easy

### Managing Containers = Kubernetes

- Containers improve agility, enhance security, optimize resources and simplify managing applications in the cloud
- An org can have millions and millions of containers
- **Kubernetes =** is an open-source platform for managing containerized workloads and services
  - It makes it easy to orchestrate many containers on many hosts, scale them, and easily deploy rollouts and rollbacks
  - This improves application reliability and reduces the time and resources needed to spend on management and operations
  - **Google Kubernetes Engine == GKE == is a Google hosted, managed Kubernetes service in the Cloud (GCP Product)**
    - _The GKE environment consists of multiple machines, specifically compute engine instances grouped to form a cluster_
    - GKE clusters can be customized, and they support different machine types, numbers of nodes, and network settings
    - GKE makes it easy to deploy applications by providing an API and a Web based console
    - GKE also provides many features that can help monitor applications, manage resources, and troubleshoot problems
- Case Study: Let's explore how Ubie, a Japan based healthcare technology startup, reduced their infrastructure costs and maintenance requirements with Google Kubernetes Engine
  - Ubie's flagship product, is AI powered questionnaire software that lets patients provide medical details before an appointment
  - Google Kubernetes Engine Autopilot, a mode that enables full management of an entire cluster's infrastructure and provides per-pod billing, presented a compelling option for the business to run Ubie for Hospital more efficiently and cost effectively
  - With GKE Autopilot, Ubie could eliminate the need to configure and monitor clusters while only paying for running pods. The shift reduced Ubie's infrastructure costs by 20%, and GKE Autopilot has helped the business eliminate Ubie for Hospital infrastructure maintenance and upgrade tasks that could take hours and days to complete
- **Cloud Run = a fully managed serverless platform to deploy and run containerized applications without needing to worry about the underlying infrastructure**
  - After your application code is containerized and deployed to Cloud Run, Google Cloud takes care of scaling and managing the infrastructure automatically
  - _Cloud Run is ideal for running stateless applications that need to scale up and down quickly in response to traffic_
  - This makes cloud run most suitable for simple and lightweight applications such as web applications
- **GKE == ideal when lots of control is required over a Kubernetes Environment and there are complex applications to run**
- **Cloud Run == is ideal for when a simple, fully managed serverless platform that can scale up and down quickly is required**

### Serverless Computing

- Serverless computing does NOT mean there's no server, it means that resources like compute power are automatically provisioned in the background as needed
- The advantage here is that organizations won't pay for compute power unless they're running a query or application
- **Serverless means that businesses provide the code for whatever function they want and the public Cloud provider does everything else**
  - Imagine you provide software to businesses that help employees manage their corporate expenses
  - You want to add a feature that lets users upload an image with their expense receipt
  - In this case, the ability to upload an image is called a function
  - You as the software development company write the code for that function directly into your public Cloud platform
  - From there, the public Cloud provider manages everything else
- One type of serverless computing solution is called **function as a service**
  - Some functions are a response to specific events, like file uploads to Cloud storage, or changes to database records
  - You write the code that defines the response to those events and the Cloud provider does everything else
- Google Cloud offers many serverless computing products
  - **Cloud Run == a fully managed environment for running containerized applications**
    - With this product, you don't have to worry about the underlying infrastructure
  - **Cloud functions == the platform for hosting simple single purpose functions that are attached to events emitted from your Cloud infrastructure and services**
    - For example, sending a notification to a mobile device when a new order is placed on a website
  - App Engine == a service to build and deploy web applications
- Serverless computing has many benefits
  - reduced operational costs
    - The Cloud provider is responsible for the infrastructure and its maintenance
    - Therefore, the application owner does not need to invest in the infrastructure or the human resources required to manage it
  - Scalability
    - Serverless computing provides automatic scaling of computing resources based on the applications demand
    - The Cloud provider manages the scaling process and the application owner only pays for the resources they use
  - Faster time to market
    - The need for infrastructure, setup and configuration is eliminated, which reduces the time required to deploy applications
    - This feature lets the application owner focus on writing code and quickly deploying new features
  - Reduce development costs
    - The development process is simplified because developers can focus on the application's logic and not on the underlying infrastructure
  - Improved resilience
    - Serverless computing offers improved resilience and availability as the Cloud provider automatically manages the infrastructure's failover and disaster recovery capabilities
  - Pay per use pricing model
    - The application owner only pays for the computing resources they use
    - This reduces the cost of unused resources and helps optimize costs
- Case Study:
  - Instead, Mashme.io started using Google's global network with App Engine before moving to Google Cloud with their own docker containers, and finally, to Google Kubernetes Engine
  - This allowed them to update their nodes and services in an almost continuous way without disruption

### Quiz

Q1 - What phrase refers to when a workload is rehosted without changing anything in the workload's code or architecture

- Refactor and reshape
- Reimagine and plan
- Move and improve
- **Lift and shift**

Question 2

Q2 - A manufacturing company is considering shifting their on-premises infrastructure to the cloud, but are concerned that access to their data and applications won't be available when they need them. They want to ensure that if one data center goes down, another will be available to prevent any disruption of service. What does this refer to?

- Security
- Flexibility
- **Reliability**
- Total cost of ownership

Q3 - A travel company is in the early stages of developing a new application and wants to test it on a variety of configurations: different operating systems, processors, and storage options. What cloud computing option should they use?

- **Virtual machine instances**
- Colocation
- A local development environment
- Containers

Q4 - What portion of a machine does a container virtualize?

- Software layers above the firmware level
- Hardware layers above the electrical level
- The entire machine
- **Software layers above the operating system level**

Q5 - What open source platform, originally developed by Google, manages containerized workloads and services?

- Angular
- **Kubernetes**
- TensorFlow
- Go

Q6 - What computing option automatically provisions resources, like compute power, in the background as needed?

- Traditional on-premises computing
- **Serverless computing**
- IaaS (infrastructure as a service)
- PaaS (platform as a service)

## Modernising Applications in the Cloud

- Application is a computer, program or software that helps users do something

### Benefits of Modern Cloud Application Development

- In the traditional software development approach (_monolithic applications_), required all the components of an application to be developed and deployed as a single, tightly coupled unit, using a single programming language

- Architecture
  - Modern cloud applications are typically built as a collection of microservices
  - **Microservices are independently deployable, scalable and maintainable components** that can be used to build a wide range of applications
  - This can help organizations bring business value to market faster because features can be released as they're completed without waiting for the rest of the application to be complete
  - _Modern applications are typically deployed to the cloud and can use managed or partially managed services_
- **Managed services = take care of the day-to-day management of cloud-based infrastructure, such as patching, upgrades, and monitoring**
- **Partially managed services = offer a hybrid approach, where businesses manage some aspects of their cloud-based applications themselves and the cloud provider manages others**
- Modern cloud applications use a pay as you go (PAYG) pricing model, which can make them extremely cost effective when configured efficiently
- Scalability
  - Modern cloud-based applications can easily be scaled up or down to meet user demands
  - Modern cloud applications are designed to be highly available and resilient with built in features like **Load balancing = which is the process of distributing network traffic evenly across multiple servers that support an application**
  - **Automatic failover = a process that allows a cloud-based application to automatically switch to a backup server if a failure occurs**
  - Cloud service providers typically offer robust _monitoring and management tools_ that allow developers to quickly identify and respond to issues, which can further improve the reliability of cloud applications

### Rehosting Legacy Applications in the Cloud

- **For legacy situations a business will utilise rehost migration path = lift and shift =** where an application is moved from an on premises environment to a cloud environment without making any changes to the application itself
  - Benefits/Advantages: Rehosting applications brings with it the many benefits of cloud computing
    - Cost savings
    - Scalability
    - Reliability
    - Security
  - Disadvantages
    - Complexity
    - Vendor lock in
- GCP Product
  - **Google Cloud VMware Engine = helps migrate existing VMware workloads to the cloud without having to re architect the applications or retool operations**
    - can maintain their existing VMware environments and operational processes while benefiting from the scalability, security and reliability of Google Cloud
    - By doing this, organizations can also access a range of Google Cloud services such as BigQuery, AI/ML and Google Kubernetes Engine, which lets them modernize their application environment and use new capabilities and technologies as needed
  - **Bare Metal Solution = For organisations with legacy applications on Orcale = fully managed cloud infrastructure solution that lets organizations run their Oracle workloads on dedicated bare metal servers in the cloud**

### APIs (Application Programming Interfaces)

- An API is a set of instructions that lets different software programs communicate with each other
- APIs can be used to create new products and services.
  - An organization could create an API that allows developers to access data from its database.
  - This data could then be used to create new products and services.
- APIs can be used to generate new revenue streams
  - An organization could charge developers to access its APIs.
  - This could generate new revenue streams for the organization and help to offset the cost of developing and maintaining the APIs.
- APIs can create partnerships.
  - By exposing APIs, organizations can create partnerships with other companies or developers which can lead to new business opportunities and collaborations.
  - By carefully considering the needs of their customers and partners, organizations can develop APIs that provide value and help to grow their businesses.

### Apigee API Management

- **API = GCP Product = Google Cloud's API management system to operate API's with enhanced scale security and automation**
- Benefits/Advantages
  - Helps organizations secure their API's by providing features such as authentication, authorization and data encryption
  - Tracks and analyzes API usage with real time analytics and historical reporting
  - Helps with developing and deploying API's through a visual API editor and a test sandbox
  - Offers API versioning, API documentation, API throttling
- Case Study: AccuWeather
  - Enabled different tiers of offerings by bundling API's into different products, each with their own rate limits and pricing
  - With the _customizable Apigee developer portal_, developers can sign up quickly, learn about the AccuWeather API's and test them out.
  - With _built in analytics_, AccuWeather can keep close tabs on who's signing up, what traffic they're producing and from where, and also observe unexpected patterns in traffic activity.

### Hybrid + Multicloud

- A **hybrid cloud = environment = combination of on premises or private cloud infrastructure and public cloud services**
  - This is the situation many organizations are currently in, where some of their data and applications have been migrated to the cloud, while others remain on premises
  - Interconnects between the private and public clouds allow interoperability
- A **multicloud = environment is where an organization uses multiple public cloud providers as part of its architecture**
  - This is ideal for organizations that need flexibility and secure connectivity between the different networks
- An organization might choose to use hybrid cloud, multi-cloud or a combination of both if they want to incorporate specific elements of a public cloud to benefit from the main strengths of that provider
  - This lets organizations
    - keep parts of the system's infrastructure on premises while they move other parts to the cloud
      - This way they create an environment that is uniquely suited to the organization's needs
    - Move only specific workloads to the cloud because a full scale migration is not required for it to work, benefit from the flexibility, scalability, and lower computing costs offered by Cloud services for running specific workloads.
    - Add specialized services such as machine learning, content caching, data analysis, long term storage, and IOT or Internet of Things to the organization's computing resources toolkit.
- How can Google Cloud help in this context?
  - Google's answer to modern hybrid and Multi-cloud distributed systems and services management is called **GKE Enterprise (GCP Product)**
    - GKE Enterprise is a managed production ready platform for running Kubernetes applications across multiple cloud environments
    - It provides a consistent way to manage Kubernetes, clusters, applications and services regardless of where they are running
    - Some of the benefits of GKE enterprise include Multi-cloud and hybrid-cloud support
    - GKE enterprise can run Kubernetes clusters on Google Cloud, AWS, Azure, and other public clouds.
    - Centralized management GKE Enterprise provides a single centralized console for managing Kubernetes clusters and applications, security and compliance
    - GKE Enterprise includes many features that help secure Kubernetes clusters and applications and comply with industry regulations, networking and load balancing
    - GKE Enterprise includes a number of features that help network and load balance Kubernetes applications, monitoring and logging GKE Enterprise provides a rich set of tools for monitoring and maintaining application consistency across an entire network, whether on premises in the cloud or in multiple clouds.
