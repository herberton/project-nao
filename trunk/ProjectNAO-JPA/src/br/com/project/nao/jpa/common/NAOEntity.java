package br.com.project.nao.jpa.common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NAOEntity<T extends NAOEntity<T>> 
	implements 
		Serializable,
		Comparable<T> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public NAOEntity() { super(); }
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public boolean temId(){
		return
			this.getId() != 0;
	}
	
	@Override
	public int hashCode() {
		return this.temId() ? toString().hashCode() : super.hashCode();
	}
	@Override
	public String toString() {
		try {
			/*if(getId() == 0) {
				return super.toString();
			} else {
				JSONObject obj = new JSONObject();
				obj.put("class", this.getClass().getName());
				obj.put("id", this.getId());
				return obj.toString();
			}*/
			
			if (this.temId()){
				return 
					String
						.format(
							"{\"id\":%s,\"class\":%s}", 
							this.getId().toString(), 
							this.getClass().getName()
						);
			}
			return super.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean equals(Object other) {
		return this.toString().equals(other.toString());
	}
	@Override
	public int compareTo(T other) {
		return 
			this.temId() && other.temId() ? 
				this.getId().compareTo(other.getId()) : 
				0;
	}

	public static <T extends NAOEntity<? extends NAOEntity<?>>> void addEntidade(Collection<T> colecao, T novaEntidade) {
		if (!colecao.contains(novaEntidade)) {
			colecao.add(novaEntidade);
		}
	}
	public static <T extends NAOEntity<? extends NAOEntity<?>>> void addEntidade(Collection<T> colecao, Collection<T> novaColecao) {
		if (novaColecao != null) {
			for (T novaEntidade : novaColecao) {
				NAOEntity.addEntidade(colecao, novaEntidade);
			}
		}
	}
	@SafeVarargs
	public static <T extends NAOEntity<? extends NAOEntity<?>>> void addEntidade(Collection<T> colecao, T...novaColecao) {
		if (novaColecao != null) {
			NAOEntity.addEntidade(colecao, Arrays.asList(novaColecao));
		}
	}
	
	public static <T extends NAOEntity<? extends NAOEntity<?>>> void removeEntidade(Collection<T> colecao, T novaEntidade) {
		if (colecao.contains(novaEntidade)) {
			colecao.remove(novaEntidade);
		}
	}
	public static <T extends NAOEntity<? extends NAOEntity<?>>> void removeEntidade(Collection<T> colecao, Collection<T> novaColecao) {
		if (novaColecao != null) {
			for (T novaEntidade : novaColecao) {
				NAOEntity.removeEntidade(colecao, novaEntidade);
			}
		}
	}
	@SafeVarargs
	public static <T extends NAOEntity<? extends NAOEntity<?>>> void removeEntidade(Collection<T> colecao, T...novaColecao) {
		if (novaColecao != null) {
			NAOEntity.removeEntidade(colecao, Arrays.asList(novaColecao));
		}
	}
}
