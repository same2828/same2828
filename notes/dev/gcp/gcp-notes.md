# Table of Contents

- [Table of Contents](#table-of-contents)
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
    - [Real-world examples: Why it’s critical to transform and embrace new technology](#real-world-examples-why-its-critical-to-transform-and-embrace-new-technology)
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
      - [So what is a hybrid or multicloud strategy used for?](#so-what-is-a-hybrid-or-multicloud-strategy-used-for)

# 1 - Digital Transformation with Google Cloud (GCP)

- IaaS = Infrastructure as a Service
- PaaS = Platform as a Service
- SaaS = Software as a Service

## Why Cloud Technology is Transforming Business

### Innovations, paradigm shifts, and digital transformation

- Paradigm Shift = A fundamental and irreversible change in the way that humans work and engage with the world
  - Current paradigm shift = Digital Transformation
- Digital Transformation = When an organization uses _new digital technologies_, such as public, private, and hybrid Cloud platforms _to create or modify_ business processes, culture, and customer experiences _to meet_ the needs of changing business and market dynamics
- Organizations choose digital transformation frameworks to:
  - Foster innovation
  - Generate new revenue streams
  - Adapt quickly to market changes and customer needs
- The IDC FutureScape report predicts
  - Over 50 percent of all IT spending will go to all digital transformation and innovation by 2024
  - By 2025, more than 90 percent of new enterprise Apps will have AI embedded within them

### What is the Cloud

- Cloud = A metaphor for the network of data centers (software, servers, computers, networks) which store and compute information that's available through the Internet

### IT Infrastructure implementations

#### On-premises (on-prem)

- Refers to hardware and software applications that are hosted on-site, located, and operated within an organization's data center to serve their unique needs
- The benefits of on-premises is that it doesn't require third-party access, which gives owners physical control over the server hardware and software, and doesn't require them to pay for ongoing excess
- However, to have the computing power to run their required workloads, organizations must buy physical servers and other infrastructure through procurement processes that can take months
- These systems require physical space, typically a specialized room with sufficient power and cooling. After configuring and deploying the systems, businesses then need expert personnel to manage them
- This long process is difficult to scale when demand spikes or business expands. Organizations often acquire more computing resources than they actually need, which results in low utilization and high overhead

#### Private Cloud

- A private Cloud is a type of Cloud computing where the infrastructure is dedicated to a single organization instead of the general public
- This type is also known as single tenant or corporate Cloud
- Typically, an organization has to perform the same ongoing maintenance and management for a private Cloud as it would for traditional on-premises infrastructure
- A private Cloud is hosted within an organization's own private servers, either at organization's own datacenter, at a third-party co-location facility or by using a private Cloud provider
- Private Cloud computing gives businesses many of the benefits of a public Cloud, including self-service, scalability, and elasticity, with more customization available from dedicated on-premises infrastructure
- Organizations might use private Cloud if they have already made significant investments in their own infrastructure, or if for regulatory reasons, data must be kept on-premises or hosted in a certain way

#### Public Cloud

- The public Cloud is where on-demand computing services and infrastructure are managed by a third party provider, such as Google Cloud, and shared with multiple organizations or tenants through the public Internet
- This sharing is why public Cloud is known as multi-tenant Cloud infrastructure
- But each tenant's data and applications running in the Cloud are hidden from other tenants. You can think of it like an apartment building that's maintained by a property management company
- The building has many units and tenants
- Each unit might have a slightly different layout, but still has all the amenities a tenant needs to live there, and each unit is locked and private to the tenant who pays for that space
- Public Cloud is what is referred to when we say "cloud"
- Because public Cloud has an on-demand availability of computing and infrastructure resources, organizations don't need to acquire, configure, or manage those resources themselves, and they only pay for what they use
- There are typically three types of Cloud computing service models available in public Cloud
  - The first is infrastructure as a service IaaS = offers compute and storage services
  - The second is Platform as a Service PaaS = offers a develop and deploy environment to build Cloud apps
  - The third is Software as a Service SaaS = delivers apps and services where users get access to software on a subscription basis

#### Hybrid Cloud

- In a hybrid Cloud, applications run in a combination of different environments
- The most common hybrid Cloud example is combining a public and private Cloud environment like an on-premises datacenter and a public Cloud computing environment like Google Cloud

#### Multi-Cloud

- The term multi-Cloud describes architectures that combine at least two public Cloud providers
- Organizations might operate a combination of on-premises and multiple public Cloud environments, therefore, implementing both hybrid and multi-Cloud simultaneously
- Today, most organizations embrace a multi-Cloud strategy
- According to the Flexera, 2022, states of the Cloud report, 89 percent of respondents reported having a multi-Cloud strategy, and 80 percent of them take a hybrid approach by combining public and private Cloud

### Benefits of cloud computing

- Scalable
  - Cloud computing gives organizations access to scalable resources and the latest technologies on-demand, so they don't need to worry about capital expenditures or limited fixed infrastructure
  - This can significantly accelerate infrastructure deployment time
- Flexible
  - Organizations and their users can access Cloud services from anywhere with an Internet connection, scaling services up or down as needed to meet business requirements
- Agile
  - Organizations can develop new applications and rapidly get them into production without worrying about the underlying infrastructure
- Strategic value offered
  - Because Cloud providers stay updated with the latest innovations and offer them as services to customers, organizations can get more competitive advantages and a higher return on investment than if they'd invested in soon to be obsolete technologies
  - This let's organizations innovate and try new ideas faster
- Secure. Cloud computing security is recognized as stronger than that in enterprise data centers because of the depth and breadth of the security mechanisms and dedicated teams that Cloud providers implement
- cost-effective

  - No matter which Cloud computing service model organizations implement, they only pay for the computing resources they use
  - They don't need to overbuild datacenter capacity to handle sudden spikes in demand or business growth, and they can deploy IT staff to work on more strategic initiatives

### Real-world examples: Why it’s critical to transform and embrace new technology

- The answer is that they consistently focus on why they exist, not how they operate
- By contrast, companies that sold encyclopedias for example all focused on how they operate, how to print and sell a specific set of books

### Cloud eras

- It started with the VM Cloud Era
  - VM stands for Virtual Machine
  - New organizations, mostly startups, realized that they could forgo ever buying or operating hardware and just start in the Cloud
  - This was a major catalyst for many of the great Cloud native companies that we rely on today, such as Twitter, Spotify, and PayPal
  - By the end of this first VM Cloud Era, very few startups operated their own datacenters
- Next was the infrastructure Cloud Era, which is when organizations migrated their IT infrastructure to the Cloud
  - This migration saved costs because infrastructure could scale up and down more quickly and easily
  - Faster development was possible because companies didn't need long-term infrastructure planning and security was better
  - Also, reducing the management load on IT staff, let organizations direct more people and resources to focus on building new capabilities
- reinventing the future means changing not only where business is done, but how it is done
  - It requires maximizing the benefits of the Cloud and building an environment that enables every person, process and technology to bring the highest level of innovation to the business
  - This is what brings us to the transformation Cloud Era, where organizations are not just making infrastructure decisions, but to truly focusing on transforming
- A transformation Cloud is a new approach to digital transformation\
  - It provides an environment for app and infrastructure modernization, data democratization, people connections, and trusted transactions
  - It's built on an easy-to-use platform with customized industry solutions that gives organizations the confidence, they're saving money and creating a more sustainable future for everyone
  - The result is an organization that benefits from Cloud computing to drive innovation, generate new revenue streams, and adapt quickly to market changes and customer needs

### Challenges that lead to a digital transformation

- First, they want to be the best at understanding, and using data
  - Today, organizations must unify data across streams, lakes, warehouses, and databases, so that they can quickly, and easily break down data silos, generate real-time insights, and make better business decisions, thus reducing cost, and inefficiencies
- Second, they want the best technology infrastructure
  - Organizations are looking for a Cloud platform that will serve as their foundation for growth, and has the flexibility to innovate securely, and adapt quickly based on market needs
- Third, they want to create the best hybrid workplace
  - The fundamental shift in how, and where we work requires new, stronger connections, and collaboration
  - Many interactions that took place in person have been digitized. This change requires more intentional connections, and collaboration
- Forth, it's critical for organizations to know that their data systems, and users are secure
  - The digital world is seeing more severe security issues, so now companies are rethinking their security posture
  - They must find ways to identify, and protect everything from people, and customers for data, and transactions in a fast changing environment
- prioritizing sustainability as a critical board level topic
  - They want to create a more sustainable future through products, and services that minimize environmental impact

### Google's Transformation Cloud

#### Data

- Data is the key to unlocking value from AI, making it critical for innovation and differentiation
- According to the new Vantage Partners Data and AI Executive Survey 2022. Only 26.5% of companies have succeeded in creating a data-driven organization to realize tangible and measurable value from their data
- A data cloud is a unified solution to manage data across the entire data life cycle regardless of whether it sits in Google Cloud or in other clouds
  - It lets organizations identify and process data with great scale, speed, security and reliability

#### Open Infrastructure

- Companies choose to modernise their IT systems on open infrastructure cloud because it gives them freedom to securely innovate and scale from on premises to edge to cloud on an easy transformative and open platform
- Open infrastructure cloud brings Google Cloud services to different physical locations while leaving the operation governance and evolution of the services to Google Cloud
- Most organizations want the freedom to run applications in the place. That makes the most sense using hybrid and multicloud approaches based on open source software
- An open infrastructure cloud facilitates fast innovation and reduces lock into a single cloud provider
  - By giving organizations a choice and flexibility to build, migrate and manager applications across on premises and multiple clouds
- Open Standard vs Open Source
  - Open standard = software that follows particular specifications that are openly accessible and usable by anyone. They have guidelines for software functionality, which help avoid vendor lock in and ensure that the products that use these standards are forming an interoperable way. Examples of open standards are HTTP for requesting content on the web, or XML for storing structured data
  - Open source = software whose source code is publicly accessible and free for anyone to use, modify and share. A decentralized community generally develops open source software as a public collaboration based on the philosophy of transparency and the open exchange of ideas
- Google's open source projects
  - Kubernetes
  - TensorFlow
  - Hybrid and multi cloud environments managed by products like Anthros (built upon Kubernetes, Istio and Knative)
- An open infrastructure embraces a partner ecosystem and the breadth of solutions it can offer its customers instead of competing with it
- Collaboration Cloud = Google Workspace
- A trusted cloud helps organizations protect what's important with advanced security tools
- According to cybersecurity ventures, the annual cost of Cybercrime is expected to reach $10.5 trillion annually by 2025
- According to IDC cloud computing is estimated to save 1 billion metric tons of CO2 emissions by 2024

### Google Cloud Adoption Framework

- 3 things
  - People
  - Process
  - Technology
- Google Cloud Adoption Framework
  - Short term tactical, midterm strategic, and long term transformational business objectives
- A cloud maturity assessment helps to establish where an organization is currently regarding the cloud adoption themes recognized by Google Cloud
  - It can quickly reveal any areas where an organization might be weaker or under invested

### Quiz

Q1 - Select the definition of digital transformation

- When an organization uses new digital technologies to create or modify on-premises business processes
- When an organization uses new digital technologies to create or modify technology infrastructure to focus on cost saving
- **When an organization uses new digital technologies to create or modify business processes, culture, and customer experiences.**
- When an organization uses new digital technologies to create or modify financial models for how a business is run

Q2 - What is the cloud?

- **A metaphor for a network of data centers.**
- A metaphor for the networking capability of internet providers
- A Google product for computing large amounts of data
- A Google product made up of on-premises IT infrastructure

Q3 - What is seen as a limitation of on-premises infrastructure, when compared to cloud infrastructure?

- **The on-premises hardware procurement process can take a long time.**
- Maintenance workers do not have physical access to the servers
- Scaling processing is too difficult due to power consumption
- The on-premises networking is more complicated

Q4 - An organization has a new application, and user subscriptions are growing faster than on-premises infrastructure can handle. What benefit of the cloud might help them in this situation?

- It provides physical access, so the organization can deploy servers faster
- It's cost effective, so the organization will no longer have to pay for computing once the app is in the cloud
- **It's scalable, so the organization could shorten their infrastructure deployment time.**
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
- **Open source software reduces the chance of vendor lock-in.**

Q7 - As the world and business changes, organizations have to decide between embracing new technology and transforming, or keeping their technology and approaches the same. What risks might an organization face by not transforming as their market evolves?

- Organizations risk losing market leadership if they spend too much time on digital transformation
- Embracing new technology can cause organizations to overspend on innovation
- Focusing on ‘how’ they operate can prevent organizations from seeing transformation opportunities
- Focusing on ‘why’ they operate can lead to inefficient use of resources and disruption

Q8 - Which item describes a goal of an organization seeking digital transformation?

- **Break down data silos and generate real time insights.**
- Ensure better security by decoupling teams and their data
- Streamline their hardware procurement process to forecast at least a quarter into the future
- Reduce emissions by using faster networks in their on-premises workloads

Q9 - Select the two capabilities that form the basis of a transformation cloud? Select two correct answers

- **Data cloud provides a unified solution to manage data across the entire data lifecycle.**
- Collaboration cloud ensures that the device a user connects with only works on the corporate network
- **Open infrastructure gives the freedom to innovate by running applications in the place that makes the most sense.**
- Sustainable cloud ensures the costs of cloud resources are controlled to prevent budget overrun
- A trusted cloud gives control of all resources to the user to ensure high availability at all times

## Fundamental Cloud Concepts

### Total Cost of Ownership (TCO)

- TCO Analysis = total cost of ownership analysis = Aims to weigh the cost of cloud adoption against the cost of running their current on-premises systems
- For on-premises TCO is associated with assessing the cost of static resources throughout their lifetime
- However, due to the dynamic nature of the cloud, predicting future costs can be challenging
  - A common mistake that organizations make when attempting to calculate cloud TCO, is to directly compare the running costs of the cloud against their on-premises system
  - These costs are NOT equivalent
  - The cost of on-premises infrastructure is dominated by the initial purchase of hardware and software, but cloud computing costs are based on monthly subscriptions or pay per use models
  - It's also important to consider all of the operational costs of running your own data center, such as power, cooling, maintenance and other support services
- A data center is a building or facility that houses a large amount of IT infrastructure, computing and storage resources in one place
- Intangible costs such as the opportunity cost of not migrating to cloud, in the miss benefits should be considered

### Capital Expenditures (CapEx) vs Operating Expenses (OpEx)

- Capital expenditure == CapEx == upfront business expenses put toward fixed assets
  - Organizations buy these items once and they benefit their business for many years
  - For example in IT, these expenditures might mean buying hardware like servers, printers, or cooling systems
  - Maintaining these assets is also considered CapEx because it extends their lifetime and usefulness
  - Small businesses can find CapEx Spending challenging because large onetime purchases are often high cost
  - The more money you put towards CapEx means less free cashflow for the rest of the business
- Then there are operating expenses or OpEx, which are recurring costs for a more immediate benefit
  - This represents the day-to-day expenses to run a business. NIT, these expenses might be yearly services like website hosting or domain registrations, or the subscription fee for Cloud services
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
- **Private cloud** is when an organization has virtualized servers in its own data centers, or those of a private cloud provider to create its own private dedicated environment
  - On-premises servers are also often referred to as private clouds, but generally, the distinction can be made that on-premises software runs in a local environment, whereas a private cloud is accessed through the Internet
  - Private cloud computing gives an organization many of the benefits of a public cloud, including self service, scalability, and elasticity
  - With more customization available than from dedicated on-premises infrastructure
  - This approach is often used when an organization has already made significant infrastructure investments, or if for regulatory reasons, data must be kept on-premises
  - See "hosted private cloud"
- **Hybrid cloud** is one in which applications are running in a combination of different environments
  - The most common example is combining a private and public cloud environment, like an on-premises data center in a public cloud computing environment like Google Cloud
- **Multicloud**, which describes architectures that combine at least two pulic cloud providers such as Google Cloud, Amazon web services, Microsoft Azure, or others
- An organization might choose multicloud if they want to take advantage of the key strengths of different public cloud providers
  - Organizations might also operate a combination of on-premises and multiple public cloud environments, effectively being both hybrid and multicloud simultaneously
  - A hybrid cloud approach is one of the most common infrastructure setups today, because organizations can continue to use their on-premises servers while also taking advantage of public cloud

#### So what is a hybrid or multicloud strategy used for?

- **Access to the latest technologies**, running workloads in multiple clouds empowers organizations to leverage the latest innovations and capabilities from each cloud provider
  - Thus taking a best-in-class approach to cloud features and obtaining the scale, security, and agility to innovate fast
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
