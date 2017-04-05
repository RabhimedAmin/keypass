package com.example.model;

import javax.persistence.*;

@Entity
	public class Demande {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "idDemande")
		private Agent agent;

		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "idDemande")
		private Ressource ressource;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Demande [id=" + id + ", agent=" + agent + ", ressource=" + ressource + ", getId()=" + getId()
					+ ", getAgent()=" + getAgent() + ", getRessource()=" + getRessource() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @return the agent
		 */
		public Agent getAgent() {
			return agent;
		}

		/**
		 * @param agent
		 *            the agent to set
		 */
		public void setAgent(Agent agent) {
			this.agent = agent;
		}

		/**
		 * @return the ressource
		 */
		public Ressource getRessource() {
			return ressource;
		}

		/**
		 * @param ressource
		 *            the ressource to set
		 */
		public void setRessource(Ressource ressource) {
			this.ressource = ressource;
		}

		/**
		 * 
		 */
		public Demande() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param id
		 * @param agent
		 * @param ressource
		 */
		public Demande(long id, Agent agent, Ressource ressource) {
			super();
			this.id = id;
			this.agent = agent;
			this.ressource = ressource;
		}

	}

